lazy val akkaHttpVersion = "10.0.10"
lazy val akkaVersion    = "2.5.4"


lazy val root = (project in file("."))
      .dependsOn(eventmanager)
    .settings(
      inThisBuild(List(
        organization    := "com.oracle",
        scalaVersion    := "2.12.3",
        version         := "0.0.1"

      )),
    name := "githubStats",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,
      "ch.megard"         %% "akka-http-cors"       % "0.2.1",
      "mysql"             %  "mysql-connector-java" % "5.1.44",
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
      "org.scalatest"     %% "scalatest"         % "3.0.1"         % Test
    )
  )
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

lazy val eventmanager = project


mainClass in Compile := Some("com.oracle.sample.githubStatsApp")

maintainer in Docker := "clca <clca@outlook.com>"

packageName in Docker := packageName.value


dockerBaseImage := "anapsix/alpine-java:latest"

dockerExposedPorts := Seq(9000)

dockerRepository := Some("clca")
