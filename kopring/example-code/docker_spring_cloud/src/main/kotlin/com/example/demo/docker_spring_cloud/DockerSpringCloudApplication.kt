package com.example.demo.docker_spring_cloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DockerSpringCloudApplication

fun main(args: Array<String>) {
	runApplication<DockerSpringCloudApplication>(*args)
}
