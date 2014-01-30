import play.Project._

name := "push-server"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
                               cache,
                               "kr.hconnect" % "hconnect-core" % "1.3.6-SNAPSHOT" changing(),
                               "kr.hconnect" % "hconnect-redis" % "1.3.6-SNAPSHOT" changing(),
                               "kr.hconnect" % "hconnect-mongo" % "1.3.6-SNAPSHOT" changing(),
                               "kr.hconnect" % "hconnect-domain-core" % "1.0-SNAPSHOT" changing()
                           )

play.Project.playScalaSettings

scalaVersion := "2.10.3"
