package com.example.demo_feign_client.feign.config

import com.example.demo_feign_client.feign.FeignPackageBase
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackageClasses = [FeignPackageBase::class])
class FeignClientConfig {
}