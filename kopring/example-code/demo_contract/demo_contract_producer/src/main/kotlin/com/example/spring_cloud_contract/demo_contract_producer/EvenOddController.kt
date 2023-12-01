package com.example.spring_cloud_contract.demo_contract_producer

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class EvenOddController {

    @GetMapping("/producer/even-odd")
    fun getEvenOdd(
        @RequestParam("number") number: Int
    ): ResponseEntity<String> {
        return if(number % 2 == 1)
            ResponseEntity.status(HttpStatus.OK).body("Odd")
        else
            ResponseEntity.status(HttpStatus.OK).body("Even")
    }

}