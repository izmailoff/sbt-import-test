
ThisBuild / scalaVersion := "2.13.8"

ThisBuild / organization := "com.example"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello",
    //libraryDependencies += "io.circe" %% "circe-yaml" % "0.14.1"
  )

lazy val loadEnv = TaskKey[Unit]("load-dev-env")
loadEnv := {
  import _root_.io.circe._
  import _root_.io.circe.yaml.parser
  import scala.io.Source
  val filename = "src/main/resources/config.yml"
  val confStr = Source.fromFile(filename).getLines.mkString("\n")
  println(confStr)
  val json: Either[ParsingFailure, Json] = parser.parse(confStr)
  println(json)
}

