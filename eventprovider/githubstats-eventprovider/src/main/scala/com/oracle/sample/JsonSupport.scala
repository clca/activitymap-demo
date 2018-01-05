package com.oracle.sample

import java.time.LocalDateTime

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol
import spray.json._

trait JsonSupport extends SprayJsonSupport {
  type HistoricStats = Map[LocalDateTime, GitHubStats]

  // import the default encoders for primitive types (Int, String, Lists etc)
  import DefaultJsonProtocol._

  implicit val statJsonFormat = jsonFormat4(GitHubStat)
  implicit val stasJsonFormat = jsonFormat1(GitHubStats)

  implicit object DateJsonFormat extends RootJsonFormat[LocalDateTime] {
    override def write(obj: LocalDateTime) = JsString(obj.toString)

    override def read(json: JsValue): LocalDateTime = json match {
      case JsString(s) => LocalDateTime.parse(s)
      case _ => throw DeserializationException("Error info you want here ...")
    }
  }

  implicit object HistoricDataJsonFormat extends RootJsonFormat[HistoricStats] {
    override def write(obj: HistoricStats) = {
      obj.map(e => {
        JsObject(
          "timestamp" -> e._1.toJson,
          "stats" -> e._2.toJson
        )
      }).toJson
    }

    override def read(json: JsValue): HistoricStats = json match {
      case JsArray(s) =>
        val map: HistoricStats = s.map(e => e.asJsObject.getFields("timestamp", "stats") match {
          case Seq(JsString(ts), st) =>
            LocalDateTime.parse(ts) -> st.convertTo[GitHubStats]
        }).toMap
        map
      case _ => throw DeserializationException("HistoricStats expected")

    }
  }

  implicit val commitJsonFormat = jsonFormat2(GitHubCommit)
  implicit val commitsJsonFormat = jsonFormat1(GitHubCommits)
}
