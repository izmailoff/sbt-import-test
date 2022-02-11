val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-yaml",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

