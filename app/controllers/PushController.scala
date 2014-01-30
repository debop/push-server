package controllers

import play.api.libs.json.Json
import play.api.mvc._
import scala.collection.mutable

/**
 * PushController
 * Created by debop on 2014. 1. 30.
 */
object PushController extends Controller {

    implicit val dataFormat = Json.format[MetaData]
    implicit val personFormat = Json.format[PushMessage]

    def ping() = Action {
        Ok(Json.toJson("pong"))
    }

    /**
    * JSON 정보로 요청할 때 파싱하는 방식입니다.
    */
    def single = Action(parse.json) { implicit request =>

        val message = request.body.as[PushMessage]
        message.extra += MetaData("a", "1")

        Ok(Json.toJson(message))
    }
}

case class PushMessage(name: String, message: String, extra: mutable.Buffer[MetaData])

case class MetaData(key: String, value: String)
