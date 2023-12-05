package com.example.jib.jib_env_variables

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JibEnvVariablesApplicationTests {

	@Test
	fun contextLoads() {
		// 개발 PC 내에 환경변수가 지정되어 있는지 확인
		println("DOCKER_SPRING_PROFILES_ACTIVE = ${ System.getenv("DOCKER_SPRING_PROFILES_ACTIVE") }")

		Assertions
			.assertThat(System.getenv("DOCKER_SPRING_PROFILES_ACTIVE"))
			.isEqualTo("docker")
	}

}
