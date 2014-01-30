package config

import org.springframework.context.annotation.{Import, Bean, Configuration}
import kr.hconnect.core.json.{JacksonSerializer, JsonSerializer}
import org.springframework.scheduling.annotation.{AsyncConfigurer, EnableAsync}
import java.util.concurrent.Executor
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.core.task.AsyncTaskExecutor
import config.servers.{RedisConfiguration, MongoConfiguration}


/**
 * Spring Framework 용 Configuration 파일입니다.
 * Created by debop on 2014. 1. 30.
 */
@Configuration
@EnableAsync
@Import(Array(classOf[MongoConfiguration], classOf[RedisConfiguration]))
class AppConfiguration extends AsyncConfigurer {

    @Bean
    def jsonSerializer: JsonSerializer = new JacksonSerializer()


    @Bean
    def asyncTashExecutor = getAsyncExecutor.asInstanceOf[AsyncTaskExecutor]

    override def getAsyncExecutor: Executor = {
        val executor = new ThreadPoolTaskExecutor()
        executor.setCorePoolSize(8)
        executor.setMaxPoolSize(128)
        executor.setQueueCapacity(256)
        executor.setThreadNamePrefix("push-")
        executor.initialize()

        executor
    }
}
