package com.example.demo_graceful_shutdown.rabbitmq

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RabbitProducer {

    private val logger : Logger = LoggerFactory.getLogger(javaClass)

    fun push(topic: String, data: String){
        logger.info("$topic 에 데이터($data) 전송 완료")
    }
}