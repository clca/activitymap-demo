package com.oracle.sample

import java.sql.DriverManager
import java.sql.Connection
import java.time._

import spray.json.DefaultJsonProtocol._
import spray.json._

object MySQLStorage extends JsonSupport {
  val driver = "com.mysql.jdbc.Driver"

  // there's probably a better way to do this
  var connection: Connection = null

  def init(host: String, password: String): Unit = {

    try {
      // make the connection
      Class.forName(driver)
      println(s"jdbc:mysql://$host:3306/?" + s"user=root&password=$password")
      connection = DriverManager.getConnection(s"jdbc:mysql://$host:3306/?" +
        s"user=root&password=$password")
      // create githubstats DB
      val statement = connection.createStatement()

      val createDb = s"""
       CREATE DATABASE IF NOT EXISTS githubstats
      """
      val resultSet = statement.executeUpdate(createDb)

      val useDB = s"""
       use githubstats
      """
      val resultSet2 = statement.executeUpdate(useDB)

      val createTable = s"""
       create table if not exists stats (id BIGINT AUTO_INCREMENT KEY, timestamp datetime, stats text, INDEX(timestamp))
      """
      val resultSet1 = statement.executeUpdate(createTable)

    } catch {
      case e: Exception => e.printStackTrace()
    }
  }

  def close(): Unit = {
    connection.close()
  }

  def insertStats(stats: Map[String, GitHubStat]): Unit = {

    insertStat(stats.values.toJson.compactPrint)
  }

  def insertStat(stat: String): Unit = {
    val statement = connection.createStatement()

    val insert = s"""
    INSERT INTO stats (timestamp, stats) VALUES(\"${LocalDateTime.now().toString}\", "${stat.replace("\"", "\\\"")}")
      """
    val resultSet = statement.executeUpdate(insert)
  }

  def getStats(start: LocalDateTime, end: LocalDateTime): Map[LocalDateTime, GitHubStats] = {
    // create the statement, and run the select query
    val statement = connection.createStatement()
    val select = s"""
    SELECT * FROM stats where timestamp >= "${start.minusDays(1).toString}" and timestamp <= "${end.plusDays(1).toString}"
      """
    val resultSet = statement.executeQuery(select)
    var retValue: Map[LocalDateTime, GitHubStats] = Map()
    while (resultSet.next()) {
      val timestamp = resultSet.getTimestamp("timestamp").toLocalDateTime
      val stats = resultSet.getString("stats").parseJson.convertTo[Seq[GitHubStat]]
      retValue += timestamp -> GitHubStats(stats)
    }
    retValue
  }
}
