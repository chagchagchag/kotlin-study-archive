package com.example.spring_cloud_contract.demo_contract_consumer.controller

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.net.URI

@RestController
class OddEvenController (
    val restTemplate: RestTemplate,
){

    @GetMapping("/check-odd-even")
    fun getCheckOddEven(
        @RequestParam("number") number: Int
    ) : String {
        val httpHeaders = HttpHeaders()

        httpHeaders.add(
            "Content-Type",
            "application/json"
        )

        val uri = URI("http://localhost:8080/odd-even/number=$number")

        val r : ResponseEntity<String> = restTemplate.exchange(
            uri,
            HttpMethod.GET,
            HttpEntity<String>(httpHeaders),
            String::class.java
        )

        return r.body ?: throw IllegalStateException()
    }

    @GetMapping("/odd-even")
    fun getOddEven(
        @RequestParam("number") number: Int
    ): ResponseEntity<String>{
        return if(number % 2 == 1)
            ResponseEntity.status(HttpStatus.OK).body("Odd")
        else
            ResponseEntity.status(HttpStatus.OK).body("Even")
    }
}