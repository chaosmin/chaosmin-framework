package tech.chaosmin.framework.configuration

import io.undertow.server.DefaultByteBufferPool
import io.undertow.websockets.jsr.WebSocketDeploymentInfo
import org.springframework.boot.web.embedded.undertow.UndertowDeploymentInfoCustomizer
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.stereotype.Component


/**
 * @author Romani min
 * @since 2021/8/9 19:25
 */
@Component
class CustomizationBean : WebServerFactoryCustomizer<UndertowServletWebServerFactory> {
    override fun customize(factory: UndertowServletWebServerFactory) {
        factory.addDeploymentInfoCustomizers(UndertowDeploymentInfoCustomizer {
            val webSocketDeploymentInfo = WebSocketDeploymentInfo()
            webSocketDeploymentInfo.buffers = DefaultByteBufferPool(false, 1024)
            it.addServletContextAttribute("io.undertow.websockets.jsr.WebSocketDeploymentInfo", webSocketDeploymentInfo)
        })
    }
}