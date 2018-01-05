lazy val eventmanager = (project in file(".")).
  settings(
    organization := "com.oracle.aura",
    name := "eventmanager",
    version := "1.0.0",
    scalaVersion    := "2.12.3",
    scalacOptions ++= Seq("-feature"),
    javacOptions in compile ++= Seq("-Xlint:deprecation"),
    publishArtifact in (Compile, packageDoc) := false,
    resolvers += Resolver.mavenLocal,
    libraryDependencies ++= Seq(
      "io.swagger" % "swagger-annotations" % "1.5.15",
      "org.glassfish.jersey.core" % "jersey-client" % "2.26-b08",
      "org.glassfish.jersey.media" % "jersey-media-multipart" % "2.26-b08",
      "org.glassfish.jersey.media" % "jersey-media-json-jackson" % "2.26-b08",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.8.9",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.8.9",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.9",
	  "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.8.9",
      "com.brsanthu" % "migbase64" % "2.2",
      "junit" % "junit" % "4.12" % "test",
      "com.novocode" % "junit-interface" % "0.10" % "test"
    )
  )

val workaround = {
  sys.props += "packaging.type" -> "jar"
  ()
}
