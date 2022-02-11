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
  val env = Config.getEnvFromConf()
  val envStr = Config.prettyPrint(env)
  s"set envVars ++= ${envStr}" :: state
}

