package com.example.demo_feign_client.feign.client.jsonplaceholder

import com.example.demo_feign_client.feign.AbstractJsonPlaceholderFeignWireMockTest
import com.github.tomakehurst.wiremock.client.WireMock
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import java.math.BigInteger

class JsonPlaceholderFeignClientWiremockTest : AbstractJsonPlaceholderFeignWireMockTest(){

    @Autowired
    private lateinit var placeholderFeignClientAgent: JsonPlaceholderFeignClientAgent

//    @Test
//    @DisplayName("GET /posts/{id} - 503 Status → IllegalStateException")
//    fun `GET posts,id - 503 Status → IllegalStateException`(){
//        // given
//        WireMock.stubFor(
//            WireMock.get(WireMock.anyUrl())
//                .willReturn(WireMock.serviceUnavailable())
//        )
//
//        // when
//        val exception = Assertions.catchThrowable {
//            placeholderFeignClientAgent.getPostId(BigInteger.TEN)
//        }
//
//        // then
//        WireMock.verify(
//            1,
//            WireMock.getRequestedFor(WireMock.urlEqualTo("/posts"))
//        )
//
//        Assertions.assertThat(exception)
//            .isInstanceOf(IllegalStateException::class.java)
//    }

    @Test
    @DisplayName("GET /posts - 503 Status → IllegalStateException")
    fun `GET posts - 503 Status → IllegalStateException`(){
        // given
        WireMock.stubFor(
            WireMock.get(WireMock.anyUrl())
                .willReturn(WireMock.serviceUnavailable())
        )

        // when
        val exception = Assertions.catchThrowable {
            placeholderFeignClientAgent.getPosts()
        }

        // then
        WireMock.verify(
            1,
            WireMock.getRequestedFor(WireMock.urlEqualTo("/posts"))
        )

        Assertions.assertThat(exception)
            .isInstanceOf(IllegalStateException::class.java)
    }
}