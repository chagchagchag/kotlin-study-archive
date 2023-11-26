package com.example.demo_feign_client.feign

import com.example.demo_feign_client.feign.config.AutoConfigureTestFeign
import com.example.demo_feign_client.feign.config.FeignUserTestContextConfiguration
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

///// 사용자 정의 어노테이션 (src/test/kotlin/com/example.demo_feign_client.feign.config 참고)
@ContextConfiguration(classes = [
    FeignUserTestContextConfiguration::class,
])
@AutoConfigureTestFeign
///// Spring 어노테이션
@ExtendWith(SpringExtension::class)
///// Property Source (Test)
@TestPropertySource(
    locations = ["classpath:feign-clients.yml"]
)
abstract class AbstractUserFeignClientIntegrationTest {
}