package com.example.demo.docker_spring_cloud.discovery_client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DiscoveryClientApplication

fun main(args: Array<String>) {
    runApplication<DiscoveryClientApplication>(*args)
}