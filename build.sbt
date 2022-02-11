ThisBuild / scalaVersion := "2.13.8"

ThisBuild / organization := "com.example"

// This is needed to get new env values from SBT:
fork := true

lazy val hello = (project in file("."))
  .settings(
    name := "Hello",
    //libraryDependencies += "io.circe" %% "circe-yaml" % "0.14.1"
  )

commands += Command.command("loadDevEnv") { state =>
  //Config.getEnvFromConf()
  val env = """Map("service.name" -> "123")"""
  s"set envVars ++= ${env}" :: state
}

