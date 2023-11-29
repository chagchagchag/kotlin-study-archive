package com.example.demo_graceful_shutdown.shutdown

import org.apache.catalina.connector.Connector
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer
import org.springframework.stereotype.Component

@Component
class GracefulShutdownTomcatConnector (
) : TomcatConnectorCustomizer {

    var connector : Connector? = null

    override fun customize(connector: Connector?) {
        this.connector = connector
    }

}