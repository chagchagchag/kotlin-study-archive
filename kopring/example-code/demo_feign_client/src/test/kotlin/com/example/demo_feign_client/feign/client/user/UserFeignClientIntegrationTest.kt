package com.example.demo_feign_client.feign.client.user

import com.example.demo_feign_client.feign.AbstractUserFeignClientIntegrationTest
import com.example.demo_feign_client.fixtures.UserCreateRequestFixture
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

internal class UserFeignClientIntegrationTest : AbstractUserFeignClientIntegrationTest() {

    @Autowired
    private lateinit var userFeignClient: UserFeignClient

    @Test
    @DisplayName("사용자 생성 요청")
    fun `사용자 생성 요청`(){
        val createUserRequest = UserCreateRequestFixture
            .normalRequest("abc@gmail.com", "abc")

        val response = userFeignClient.createUser(createUserRequest)
        println("""
            response.body = ${response.body()}
        """.trimIndent())
    }

}