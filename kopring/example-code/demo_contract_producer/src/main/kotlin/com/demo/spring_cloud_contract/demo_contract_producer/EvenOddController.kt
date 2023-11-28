package com.demo.spring_cloud_contract.demo_contract_producer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class EvenOddController {

    @GetMapping("/validate/prime-number")
    fun isNumberPrime(
        @RequestParam("number") number: Int
    ): String {
        return if (number % 2 == 1)
            "Odd"
        else
            "Even"
    }
}