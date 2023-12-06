package com.example.demo.docker_spring_cloud.api_gateway_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiGatewayServiceApplication

fun main(args: Array<String>){
    runApplication<ApiGatewayServiceApplication>(*args)
}