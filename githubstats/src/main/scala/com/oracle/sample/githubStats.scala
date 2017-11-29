package com.oracle.sample

import akka.actor.{ ActorRef, ActorSystem }
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

import scala.concurrent.{ ExecutionContext, Future }
import scala.io.StdIn

//#main-class
object githubStatsApp extends App with StatsRoutes {

  // set up ActorSystem and other dependencies here
  //#main-class
  //#server-bootstrapping
  implicit val system: ActorSystem = ActorSystem("GitHubStats")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  //#server-bootstrapping

  // Needed for the Future and its methods flatMap/onComplete in the end
  implicit val executionContext: ExecutionContext = system.dispatcher

  val statsActor: ActorRef = sys.env("VERSION") match {
    case "V3" => system.actorOf(StatsStorageActor.props, "statsStorageActor")
    case _ => system.actorOf(StatsActor.props, "statsActor")
  }

  //#main-class
  // from the UserRoutes trait
  lazy val routes: Route = getRoute()
  //#main-class

  //#http-server
  Http().bindAndHandle(routes, "0.0.0.0", 9000)

  println(s"Server online at http://0.0.0.0:9000/ ...")

  //#http-server
  //#main-class
}
//#main-class
