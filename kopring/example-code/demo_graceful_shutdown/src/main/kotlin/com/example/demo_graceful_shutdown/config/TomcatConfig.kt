package com.example.demo_graceful_shutdown.config

import com.example.demo_graceful_shutdown.shutdown.GracefulShutdownTomcatConnector
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TomcatConfig (
    val gracefulShutdownTomcatConnector: GracefulShutdownTomcatConnector,
){

    @Bean
    fun webserverFactory(): ConfigurableServletWebServerFactory {
        val factory: TomcatServletWebServerFactory = TomcatServletWebServerFactory()
        factory.addConnectorCustomizers(gracefulShutdownTomcatConnector)
        return factory
    }

}