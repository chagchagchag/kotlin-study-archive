package com.example.demo_feign_client.feign

import com.example.demo_feign_client.feign.config.AutoConfigureTestFeign
import com.example.demo_feign_client.feign.config.FeignUserTestContextConfiguration
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

/** 1) 사용자 정의 어노테이션
 *  (src/test/kotlin/com/example.demo_feign_client.feign.config 참고)
 *  - FeignUserTestContextConfiguration
 *  - AutoConfigureTestFeign
 *  2) Spring Layer
 *  3) Properties
 **/

// -- 1) 사용자 정의 어노테이션
@ContextConfiguration(classes = [
    FeignUserTestContextConfiguration::class,
])
@AutoConfigureTestFeign
// -- 2) Spring Layer
@ExtendWith(SpringExtension::class)
// -- 3) Properties
@TestPropertySource(locations = ["classpath:feign-clients.yml"])
abstract class AbstractUserFeignClientIntegrationTest
