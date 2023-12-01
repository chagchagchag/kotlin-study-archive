package com.example.spring_cloud_contract.demo_contract_producer.contracts

import com.example.spring_cloud_contract.demo_contract_producer.EvenOddController
import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
class EvenOddContractBaseTestClass {

    @Autowired
    lateinit var evenOddController: EvenOddController

    @BeforeEach
    fun setup(){
        val standaloneMockMvcBuilder =
            MockMvcBuilders.standaloneSetup(evenOddController)

        RestAssuredMockMvc
            .standaloneSetup(standaloneMockMvcBuilder)
    }

}