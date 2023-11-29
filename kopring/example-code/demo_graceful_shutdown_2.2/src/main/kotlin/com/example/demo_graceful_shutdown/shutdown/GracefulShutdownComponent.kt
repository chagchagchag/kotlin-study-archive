package com.example.demo_graceful_shutdown.shutdown

import com.example.demo_graceful_shutdown.rabbitmq.RabbitProducer
import org.apache.tomcat.util.threads.ThreadPoolExecutor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
//import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

@Component
class GracefulShutdownComponent (
    val rabbitProducer: RabbitProducer,
    val gracefulShutdownTomcatConnector: GracefulShutdownTomcatConnector,
){

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @EventListener(ContextClosedEvent::class)
    fun onClose(){
        rabbitProducer.push("GRACEFUL_SHUTDOWN_TOPIC", "2023.11.30.10:00:00")
        gracefulShutdownTomcatConnector.connector?.let{
            it.pause()

            val threadPoolExecutor = it.protocolHandler.executor as ThreadPoolExecutor

            threadPoolExecutor.shutdown()

            try{
                threadPoolExecutor.awaitTermination(20, TimeUnit.SECONDS)
                logger.info("Stop Completed")
            } catch (e: InterruptedException){
                Thread.currentThread().interrupt()
                e.printStackTrace()
                logger.error("Web Application Graceful Shutdown FAILED... ")
            }
        }
    }
}