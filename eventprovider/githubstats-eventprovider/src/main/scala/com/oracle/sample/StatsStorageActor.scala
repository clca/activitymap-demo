package com.oracle.sample

import akka.actor.{ Actor, ActorLogging, Props }

import scala.math._
import MySQLStorage._
import java.time._

import com.oracle.sample.StatsStorageActor.GetStatsByDateRange
object StatsStorageActor {

  final case class GetStatsByDateRange(from: LocalDateTime, to: LocalDateTime)

  def props: Props = Props[StatsStorageActor]
}

class StatsStorageActor extends Actor with ActorLogging {
  import StatsActor._
  val mysql = MySQLStorage

  val mySqlHost = sys.env("MYSQL_HOST")
  val mySqlPassword = sys.env("MYSQL_PASSWORD")

  println(s"connecting to Host:$mySqlHost Password:$mySqlPassword")

  mysql.init(mySqlHost, mySqlPassword)

  private val devsXState = Map[String, Int](
    "AL" -> 156,
    "AK" -> 17,
    "AS" -> 11,
    "AZ" -> 430,
    "AR" -> 75,
    "CA" -> 6185,
    "CO" -> 751,
    "CT" -> 183,
    "DE" -> 1435,
    "DC" -> 385,
    "FL" -> 774,
    "GA" -> 884,
    "GU" -> 35,
    "HI" -> 57,
    "ID" -> 103,
    "IL" -> 985,
    "IN" -> 693,
    "IA" -> 131,
    "KS" -> 101,
    "KY" -> 121,
    "LA" -> 407,
    "ME" -> 57,
    "MH" -> 21,
    "MD" -> 431,
    "MA" -> 1596,
    "MI" -> 535,
    "MN" -> 464,
    "MS" -> 114,
    "MO" -> 370,
    "MT" -> 120,
    "NE" -> 114,
    "NV" -> 92,
    "NH" -> 108,
    "NJ" -> 470,
    "NM" -> 85,
    "NY" -> 1999,
    "NC" -> 824,
    "ND" -> 31,
    "MP" -> 4,
    "OH" -> 424,
    "OK" -> 85,
    "OR" -> 561,
    "PW" -> 2,
    "PA" -> 1056,
    "PR" -> 319,
    "RI" -> 82,
    "SC" -> 576,
    "SD" -> 22,
    "TN" -> 315,
    "TX" -> 1751,
    "UT" -> 215,
    "VT" -> 44,
    "VI" -> 9,
    "VA" -> 785,
    "WA" -> 1836,
    "WV" -> 30,
    "WI" -> 374,
    "WY" -> 3
  )
  private val maxDevs = devsXState.maxBy(_._2)._2

  var stats = Map[String, GitHubStat](
    "AL" -> GitHubStat("AL", 1, 1, 1),
    "AK" -> GitHubStat("AK", 1, 1, 1),
    "AS" -> GitHubStat("AS", 1, 1, 1),
    "AZ" -> GitHubStat("AZ", 1, 1, 1),
    "AR" -> GitHubStat("AR", 1, 1, 1),
    "CA" -> GitHubStat("CA", 1, 1, 1),
    "CO" -> GitHubStat("CO", 1, 1, 1),
    "CT" -> GitHubStat("CT", 1, 1, 1),
    "DE" -> GitHubStat("DE", 1, 1, 1),
    "DC" -> GitHubStat("DC", 1, 1, 1),
    "FL" -> GitHubStat("FL", 1, 1, 1),
    "GA" -> GitHubStat("GA", 1, 1, 1),
    "GU" -> GitHubStat("GU", 1, 1, 1),
    "HI" -> GitHubStat("HI", 1, 1, 1),
    "ID" -> GitHubStat("ID", 1, 1, 1),
    "IL" -> GitHubStat("IL", 1, 1, 1),
    "IN" -> GitHubStat("IN", 1, 1, 1),
    "IA" -> GitHubStat("IA", 1, 1, 1),
    "KS" -> GitHubStat("KS", 1, 1, 1),
    "KY" -> GitHubStat("KY", 1, 1, 1),
    "LA" -> GitHubStat("LA", 1, 1, 1),
    "ME" -> GitHubStat("ME", 1, 1, 1),
    "MH" -> GitHubStat("MH", 1, 1, 1),
    "MD" -> GitHubStat("MD", 1, 1, 1),
    "MA" -> GitHubStat("MA", 1, 1, 1),
    "MI" -> GitHubStat("MI", 1, 1, 1),
    "MN" -> GitHubStat("MN", 1, 1, 1),
    "MS" -> GitHubStat("MS", 1, 1, 1),
    "MO" -> GitHubStat("MO", 1, 1, 1),
    "MT" -> GitHubStat("MT", 1, 1, 1),
    "NE" -> GitHubStat("NE", 1, 1, 1),
    "NV" -> GitHubStat("NV", 1, 1, 1),
    "NH" -> GitHubStat("NH", 1, 1, 1),
    "NJ" -> GitHubStat("NJ", 1, 1, 1),
    "NM" -> GitHubStat("NM", 1, 1, 1),
    "NY" -> GitHubStat("NY", 1, 1, 1),
    "NC" -> GitHubStat("NC", 1, 1, 1),
    "ND" -> GitHubStat("ND", 1, 1, 1),
    "MP" -> GitHubStat("MP", 1, 1, 1),
    "OH" -> GitHubStat("OH", 1, 1, 1),
    "OK" -> GitHubStat("OK", 1, 1, 1),
    "OR" -> GitHubStat("OR", 1, 1, 1),
    "PW" -> GitHubStat("PW", 1, 1, 1),
    "PA" -> GitHubStat("PA", 1, 1, 1),
    "PR" -> GitHubStat("PR", 1, 1, 1),
    "RI" -> GitHubStat("RI", 1, 1, 1),
    "SC" -> GitHubStat("SC", 1, 1, 1),
    "SD" -> GitHubStat("SD", 1, 1, 1),
    "TN" -> GitHubStat("TN", 1, 1, 1),
    "TX" -> GitHubStat("TX", 1, 1, 1),
    "UT" -> GitHubStat("UT", 1, 1, 1),
    "VT" -> GitHubStat("VT", 1, 1, 1),
    "VI" -> GitHubStat("VI", 1, 1, 1),
    "VA" -> GitHubStat("VA", 1, 1, 1),
    "WA" -> GitHubStat("WA", 1, 1, 1),
    "WV" -> GitHubStat("WV", 1, 1, 1),
    "WI" -> GitHubStat("WI", 1, 1, 1),
    "WY" -> GitHubStat("WY", 1, 1, 1)
  )

  val CommitsRatio = 100
  val StarsRatio = 10
  val EventsRatio = 250

  def updateStat(stat: GitHubStat): GitHubStat = {
    val ratio: Double = devsXState.getOrElse(stat.state, maxDevs).toDouble / maxDevs

    stat.copy(
      numCommits = stat.numCommits + floor(random() * CommitsRatio * ratio).toLong,
      numStars = stat.numStars + floor(random() * StarsRatio * ratio).toInt,
      numEvents = stat.numEvents + floor(random() * EventsRatio * ratio).toInt
    )
  }

  def updateStats(): Map[String, GitHubStat] = {
    stats.map(e => e._1 -> updateStat(e._2))
  }

  def getStats(state: String): GitHubStat = {

    stats.get(state) match {
      case Some(s) =>
        val stat = updateStat(s)
        stats += state -> stat
        stat
      case None =>
        val newStat = updateStat(GitHubStat(state, 1, 1, 1))
        stats += state -> newStat
        newStat
    }
  }

  def receive: Receive = {
    case GetStats =>
      stats = updateStats()
      mysql.insertStats(stats)
      sender() ! GitHubStats(stats.values.toSeq)
    case GetStat(state) =>
      stats = updateStats()
      mysql.insertStats(stats)
      sender() ! getStats(state)
    case GetStatsByDateRange(from, to) =>
      val s = mysql.getStats(from, to)
      sender() ! s
    case _ =>
      log.error("uknown message in StatsStorageActor")
  }
}
