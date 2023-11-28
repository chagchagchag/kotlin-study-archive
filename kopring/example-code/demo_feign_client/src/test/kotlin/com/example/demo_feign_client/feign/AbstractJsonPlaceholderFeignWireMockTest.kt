package com.example.demo_feign_client.feign

import com.example.demo_feign_client.feign.config.AutoConfigureTestFeign
import com.example.demo_feign_client.feign.config.FeignJsonPlaceholderTestContextConfiguration
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

// 1) custom annotation
@ContextConfiguration(classes = [FeignJsonPlaceholderTestContextConfiguration::class])
@AutoConfigureTestFeign
// 2) wiremock
@AutoConfigureWireMock(port = 0)
// 3) spring
@ActiveProfiles("wiremock")
@ExtendWith(SpringExtension::class)
// 4) property
@TestPropertySource(locations = ["classpath:feign-clients.yml"])
abstract class AbstractJsonPlaceholderFeignWireMockTest {
}