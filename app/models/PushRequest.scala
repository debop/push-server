package models

import org.joda.time.DateTime
import scala.collection.mutable

/**
 * AbstractPushMessage
 * Created by debop on 2014. 1. 30.
 */

case class ExtraData(key: String, value: String)


case class SinglePushRequest(deviceId: String,
                             serverApiKey: String,
                             eventKey: String,
                             body: String,
                             extraData: Option[Seq[ExtraData]] = None,
                             reservedTime: Option[DateTime] = None,
                             pushVender: Option[PushVender] = None)


case class MultiPushRequest(deviceIds: mutable.Set[String],
                            serverApiKey: String,
                            eventKey: String,
                            body: String,
                            extraData: Seq[ExtraData],
                            requestTime: DateTime = DateTime.now,
                            reservedTime: DateTime,
                            sentTime: DateTime,
                            pushVender: PushVender = PushVender.Google,
                            errorCount: Int = 0,
                            errorCode: String,
                            errorMessage: String)


case class ServicePushRequest(serviceId: String,
                              serverApiKey: String,
                              eventKey: String,
                              body: String,
                              extraData: Seq[ExtraData],
                              requestTime: DateTime = DateTime.now,
                              reservedTime: DateTime,
                              sentTime: DateTime,
                              pushVender: PushVender = PushVender.Google,
                              errorCount: Int = 0,
                              errorCode: String,
                              errorMessage: String)

