package com.example.demo_feign_client.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "internal-api")
data class InternalApiConfigProperties(
    val user: String,
)
