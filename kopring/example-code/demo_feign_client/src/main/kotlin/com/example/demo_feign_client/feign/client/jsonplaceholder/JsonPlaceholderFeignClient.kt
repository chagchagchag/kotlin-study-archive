package com.example.demo_feign_client.feign.client.jsonplaceholder

import com.example.demo_feign_client.exception.Validator
import com.example.demo_feign_client.valueobject.PostReadResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import feign.Response
import org.slf4j.LoggerFactory
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.math.BigInteger

@FeignClient(
    name = "jsonPlaceholder",
    url = "\${external-api.placeholder}",
)
interface JsonPlaceholderFeignClient {

    @GetMapping("/posts/{postId}")
    fun getPostById(
        @PathVariable("postId") id : BigInteger,
    ): Response

    @GetMapping("/posts")
    fun getPosts(): Response

}

@Component
class JsonPlaceholderFeignClientAgent (
    val jsonPlaceholderFeignClient: JsonPlaceholderFeignClient,
    val objectMapper: ObjectMapper,
){

    val logger = LoggerFactory.getLogger(JsonPlaceholderFeignClient::class.java)

    fun getPostId(id: BigInteger)
    : PostReadResponse {
        val response = jsonPlaceholderFeignClient
            .getPostById(id)

        val serialized = String(
            Validator
                .validateHttpStatus(response)
                .body().asInputStream()
                .readAllBytes()
        )

        logger.info("""
            >>> 
            request ::: ${response.request()},
            response ::: $serialized
        """.trimIndent())

        return objectMapper.readValue<PostReadResponse>(serialized)
    }

    fun getPosts()
    : List<PostReadResponse>{
        val response = jsonPlaceholderFeignClient
            .getPosts()

        val serialized = String(
            Validator
                .validateHttpStatus(response)
                .body().asInputStream()
                .readAllBytes()
        )

        logger.info("""
            >>> 
            request ::: ${response.request()},
            response ::: $serialized
        """.trimIndent())

        return objectMapper.readValue<List<PostReadResponse>>(serialized)
    }

}