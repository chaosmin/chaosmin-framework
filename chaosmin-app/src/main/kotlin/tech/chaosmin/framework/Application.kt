package tech.chaosmin.framework

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Import
import springfox.documentation.oas.annotations.EnableOpenApi

/**
 * @author Romani min
 * @since 2021/7/19 18:45
 */
@EnableOpenApi
@EnableDiscoveryClient
@Import(cn.hutool.extra.spring.SpringUtil::class)
@SpringBootApplication
open class Application<T> {
    fun <T> start(clazz: Class<T>, args: Array<String>) {
        val logger = LoggerFactory.getLogger(clazz)
        val app = SpringApplication.run(clazz, *args)
        logger.error("Application[${app.id}] is ${if (app.isRunning) "running" else "stop"} now.")
    }
}