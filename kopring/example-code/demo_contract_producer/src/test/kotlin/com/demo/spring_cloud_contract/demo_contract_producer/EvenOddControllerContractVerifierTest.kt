package com.demo.spring_cloud_contract.demo_contract_producer

import io.restassured.module.mockmvc.RestAssuredMockMvc
import io.restassured.module.mockmvc.RestAssuredMockMvc.given
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@DirtiesContext
//@AutoConfigureMessageVerifier
class EvenOddControllerContractVerifierTest {

    /**
     * 작성하지 않아도 된다.
     * groovy로 Contract를 작성 후 Build 를 하면 아래와 비슷한 Test코드가 따로 자동으로 생성된다..ㄷㄷ
     */

//    @Autowired
//    lateinit var evenOddController: EvenOddController
//
//    @BeforeEach
//    fun init(){
//        val standaloneMockMvcBuilder : StandaloneMockMvcBuilder
//        = MockMvcBuilders.standaloneSetup(evenOddController)
//
//        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder)
//    }
//
//    @Test
//    @DisplayName("(validation) 짝수를 요청하면 'Even' 을 Return 해야한다")
//    fun shouldReturnEvenNumber_when_evenNumber_Requested(){
//        val mockMvcRequestSpecification = RestAssuredMockMvc.given()
//
//        val response = given()
//            .spec(mockMvcRequestSpecification)
//            .queryParam("number", "2")
//            .get("/validate/prime-number")
//
//        assertThat(response.statusCode).isEqualTo(200)
//
//        val responseBody = response.body.asString()
//        assertThat(responseBody).isEqualTo("Even")
//    }
}