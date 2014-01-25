package controllers

import play.api.mvc._
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.global

object Application extends Controller {

    def index = Action {
        Ok(views.html.index("Push Server"))
    }

    def push(jsonText: String) = Action.async {
        future {
            Ok("success")
        }
    }

}