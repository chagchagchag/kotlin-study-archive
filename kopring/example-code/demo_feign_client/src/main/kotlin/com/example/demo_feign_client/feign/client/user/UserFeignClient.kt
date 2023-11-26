package com.example.demo_feign_client.feign.client.user

import com.example.demo_feign_client.valueobject.UserCreateRequest
import com.example.demo_feign_client.valueobject.UserCreateResponse
import com.example.demo_feign_client.valueobject.UserReadResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import feign.FeignException
import feign.Response
import org.slf4j.LoggerFactory
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.PropertySource
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

@FeignClient(
    value = "user", url = "\${internal-api.user}"
)
@PropertySource("classpath:feign-clients.yml")
interface UserFeignClient {
    @GetMapping("/user/{id}")
    fun getUser(@PathVariable("id") id : UUID): Response

    @PostMapping("/user")
    fun createUser(@RequestBody userCreateRequest: UserCreateRequest): Response
}

@Component
class UserFeignClientAgent(
    private val userFeignClient: UserFeignClient,
    private val objectMapper: ObjectMapper,
){
    val logger = LoggerFactory.getLogger(UserFeignClientAgent::class.java)

    fun createUser(userCreateRequest: UserCreateRequest)
    : UserCreateResponse {
        val response = try {
            userFeignClient
                .createUser(userCreateRequest)
                .throwExceptionIfBadStatus()
        } catch (feignException: FeignException){
            throw IllegalStateException(feignException)
        }

        val responseBody = String(response.body().asInputStream().readAllBytes())
        logger.info("""
            >>> 
            request ::: ${response.request()}, 
            response ::: $responseBody 
        """.trimIndent())

        return objectMapper.readValue<UserCreateResponse>(responseBody)
    }

    fun readUserByUserId(userId: UUID)
    : UserReadResponse{
        val response = try {
            userFeignClient
                .getUser(userId)
                .throwExceptionIfBadStatus()
        } catch (feignException : FeignException) {
            throw IllegalStateException(feignException)
        }

        val responseBody = String(response.body().asInputStream().readAllBytes())
        logger.info("""
            >>> 
            request ::: ${response.request()},
            response ::: $responseBody 
        """.trimIndent())

        return objectMapper.readValue<UserReadResponse>(responseBody)
    }

    private fun Response.throwExceptionIfBadStatus(): Response {
        if(HttpStatus.OK !== HttpStatus.valueOf(status())){
            throw IllegalStateException("Server Answered Error. status code = ${status()}")
        }
        return this
    }
}