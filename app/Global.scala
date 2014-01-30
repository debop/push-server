import config.AppConfiguration
import kr.hconnect.core.spring.Springs
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import play.api.{Application, GlobalSettings}

/**
 * Global
 * Created by debop on 2014. 1. 26..
 */
object Global extends GlobalSettings {

    lazy val log = LoggerFactory.getLogger(getClass)

    override def onStart(app: Application) {
        super.onStart(app)

        Springs.init(new AnnotationConfigApplicationContext(classOf[AppConfiguration]))

        log.info(s"Application을 시작했습니다.\nconfiguration=${app.configuration}")
    }
}
