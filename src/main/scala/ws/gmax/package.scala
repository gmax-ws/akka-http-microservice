package ws

import java.util.concurrent.TimeUnit

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.util.Timeout
import com.typesafe.config.Config

import scala.concurrent.ExecutionContextExecutor

package object gmax {
  implicit val system: ActorSystem = ActorSystem("person-services")
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val timeout: Timeout = Timeout(30, TimeUnit.SECONDS)

  val config: Config = system.settings.config.getConfig("app")
  val port: Int = config.getInt("http-port")
  val withCorsFilter: Boolean = config.getBoolean("withCorsFilter")
  val localhostAuth: Boolean = config.getBoolean("localhostAuth")
}
