package controllers

import play.api.mvc._
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import org.slf4j.LoggerFactory

object Application extends Controller {

    lazy val log = LoggerFactory.getLogger(getClass)

    def index = Action {
        log.info("Application Index.")
        Ok(views.html.index("Push Server"))
    }

    def push(jsonText: String) = Action.async {
        future {
            Ok("success")
        }
    }

}