package com.example.spring_cloud_contract.demo_contract_consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoContractConsumerApplication

fun main(args: Array<String>) {
	runApplication<DemoContractConsumerApplication>(*args)
}
