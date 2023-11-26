package com.example.demo_feign_client.config

import com.example.demo_feign_client.config.properties.ExternalApiConfigProperties
import com.example.demo_feign_client.config.properties.InternalApiConfigProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(
    InternalApiConfigProperties::class,
    ExternalApiConfigProperties::class,
)
class EnableConfigPropertiesConfig {
}