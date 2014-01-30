package config.servers

import com.mongodb.{MongoClientOptions, WriteConcern}
import kr.hconnect.mongo.config.MongoConfigBase
import org.springframework.context.annotation.{Bean, Configuration}
import models.SinglePushRequest

/**
 * MongoConfiguration
 * Created by debop on 2014. 1. 30.
 */
@Configuration
class MongoConfiguration extends MongoConfigBase {

    override def getDatabaseName: String = "pushDb"

    override def getMappingBasePackage = classOf[SinglePushRequest].getPackage.getName

    override def getWriteConcern = WriteConcern.SAFE

    @Bean
    override def mongoOptions(): MongoClientOptions =
        MongoClientOptions.builder()
        .connectionsPerHost(16)
        .threadsAllowedToBlockForConnectionMultiplier(8)
        .autoConnectRetry(true)
        .connectTimeout(1000)
        .maxWaitTime(1500)
        .socketKeepAlive(true)
        .writeConcern(getWriteConcern)
        .build()
}
