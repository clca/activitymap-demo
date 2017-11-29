package com.oracle.sample

import java.lang.management.ManagementFactory

import akka.actor.{ ActorRef, ActorSystem }
import akka.event.Logging

import scala.concurrent.duration._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.delete
import akka.http.scaladsl.server.directives.MethodDirectives.get
import akka.http.scaladsl.server.directives.MethodDirectives.post
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.http.scaladsl.server.directives.PathDirectives.path

import scala.concurrent.Future
import akka.pattern.ask
import akka.util.Timeout
import com.oracle.sample.StatsActor._
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._
import java.time.{ LocalDate, LocalDateTime }
import java.time.format.{ DateTimeFormatter, DateTimeFormatterBuilder }

import com.oracle.sample.StatsStorageActor.GetStatsByDateRange

trait StatsRoutes extends JsonSupport {

  // we leave these abstract, since they will be provided by the App
  implicit def system: ActorSystem

  lazy val log = Logging(system, classOf[StatsRoutes])

  // other dependencies that UserRoutes use
  def statsActor: ActorRef

  // Required by the `ask` (?) method below
  implicit lazy val timeout = Timeout(5.seconds) // usually we'd obtain the timeout from the system's configuration

  val currentVersion = sys.env("VERSION") match {
    case "V1" => "v1"
    case "V2" => "v2"
    case "V3" => "v3"
    case _ => "v2 default"
  }

  def getRoute(): Route = {
    println(s"Running githubstats version:${sys.env("VERSION")}")
    sys.env("VERSION") match {
      case "V1" => commitOnlyStatsRoutes
      case "v2" => allStatsRoutes
      case "V3" => StatsStorageRouts
      case _ => allStatsRoutes
    }
  }
  val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

  private def statusMessage: String = s"$currentVersion with CORS ${Duration(ManagementFactory.getRuntimeMXBean.getUptime, MILLISECONDS).toString()}"

  lazy val commitOnlyStatsRoutes: Route =
    pathPrefix("githubstats") {
      pathPrefix("status") {
        get {
          log.info("/status executed")
          cors() {
            complete(statusMessage)
          }
        }
      } ~
        pathPrefix("commits") {
          concat(
            pathEnd {
              concat(
                get {
                  val commits: Future[GitHubCommits] =
                    (statsActor ? GetCommits).mapTo[GitHubCommits]
                  cors() {
                    complete(commits)
                  }
                }
              )
            },
            path(Segment) { usState =>
              concat(
                get {
                  //#retrieve-user-info
                  val commit: Future[GitHubCommit] =
                    (statsActor ? GetCommit(usState)).mapTo[GitHubCommit]
                  rejectEmptyResponse {
                    cors() {
                      complete(commit)
                    }
                  }
                }
              )
            }
          )
        }
    }
  //#all-routes

  lazy val allStatsRoutes: Route =
    pathPrefix("githubstats") {
      pathPrefix("status") {
        get {
          log.info("/status executed")
          cors() {
            complete(statusMessage)
          }
        }
      } ~
        pathPrefix("stats") {
          concat(
            pathEnd {
              concat(
                get {
                  val users: Future[GitHubStats] =
                    (statsActor ? GetStats).mapTo[GitHubStats]
                  cors() {
                    complete(users)
                  }
                }
              )
            },
            path(Segment) { usState =>
              concat(
                get {
                  //#retrieve-user-info
                  val stat: Future[GitHubStat] =
                    (statsActor ? GetStat(usState)).mapTo[GitHubStat]
                  rejectEmptyResponse {
                    cors() {
                      complete(stat)
                    }
                  }
                }
              )
            }
          )
        }
    }
  //#all-routes
  lazy val StatsStorageRouts: Route =
    allStatsRoutes ~
      pathPrefix("githubstats") {
        pathPrefix("history") {
          get {
            parameters('from.as[String], 'to.as[String]) { (from, to) =>
              val stat: Future[Map[LocalDateTime, GitHubStats]] =
                (statsActor ? GetStatsByDateRange(LocalDate.parse(from, formatter).atTime(12, 0), LocalDate.parse(to, formatter).atTime(12, 0))).mapTo[Map[LocalDateTime, GitHubStats]]
              rejectEmptyResponse {
                cors() {

                  complete(stat)
                }

              }
            }
          }
        }
      }
}
