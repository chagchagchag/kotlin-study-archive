package com.example.spring_cloud_contract.demo_contract_producer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoContractProducerApplication

fun main(args: Array<String>){
    runApplication<DemoContractProducerApplication>(*args)
}