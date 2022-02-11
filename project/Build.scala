
case class Service(port: Integer, service: String)

case class System(system: Service)

object Config {

    def getEnvFromConf(): Map[String, String] = {
        val filename = "src/main/resources/config.yml"
        val confStr = readConfig(filename)
        val conf = parseConfig(confStr)
        println(conf)
        val env = toEnv(conf)
        env
    }

    def readConfig(filename: String): String = {
      import scala.io.Source
      Source.fromFile(filename).getLines.mkString("\n") // use better way?
    }

    def parseConfig(conf: String): System = {
      import _root_.io.circe._
      import _root_.io.circe.yaml
      import _root_.io.circe.yaml._
      import _root_.io.circe.yaml.syntax._
      import _root_.io.circe.generic.auto._
      import cats.syntax.either._
      val json: Either[ParsingFailure, Json] = yaml.parser.parse(conf)
      json
        .leftMap(err => err: Error)
        .flatMap(_.as[System])
        .valueOr(throw _)
    }

    def toEnv(conf: System): Map[String, String] = {
      Map(s"service.${conf.system.service}" -> conf.system.port.toString)
    }
}

