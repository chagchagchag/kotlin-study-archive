package com.example.demo_graceful_shutdown

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoGracefulShutdownApplication

fun main(args: Array<String>) {
	runApplication<DemoGracefulShutdownApplication>(*args)
}
