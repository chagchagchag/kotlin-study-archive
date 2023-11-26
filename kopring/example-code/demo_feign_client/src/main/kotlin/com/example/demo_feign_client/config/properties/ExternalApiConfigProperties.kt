package com.example.demo_feign_client.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "external-api")
data class ExternalApiConfigProperties (
    val placeholder: String,
)