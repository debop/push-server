import play._

name := "push-server"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
    cache
)

play.Project.playScalaSettings
