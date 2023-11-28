package com.example.demo_feign_client.feign.client.jsonplaceholder

import com.example.demo_feign_client.exception.Validator
import com.example.demo_feign_client.feign.AbstractJsonPlaceholderFeignClientIntegrationTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.math.BigInteger

class JsonPlaceholderFeignClientIntegrationTest : AbstractJsonPlaceholderFeignClientIntegrationTest(){

    @Autowired
    private lateinit var jsonPlaceholderFeignClient: JsonPlaceholderFeignClient

    @Test
    @DisplayName("jsonplaceholder get 요청")
    fun `jsonplaceholder get 요청`(){
        val response = jsonPlaceholderFeignClient.getPostById(BigInteger.valueOf(1000))

        println("""
            response.body = ${response.body()}
        """.trimIndent())
    }

    @Test
    @DisplayName("jsonplaceholder list 요청")
    fun `jsonplaceholder list 요청`(){
        val response = jsonPlaceholderFeignClient.getPosts()

        println("""
            response.body = ${response.body()}
        """.trimIndent())
    }

}