package com.example.demo_feign_client.exception

import feign.Response
import org.springframework.http.HttpStatus

class Validator {

    companion object {
        fun validateHttpStatus(response: Response): Response {
            if(HttpStatus.valueOf(response.status()) !== HttpStatus.OK){
                throw IllegalStateException("HttpStatus 가 OK가 아닙니다.")
            }
            return response
        }
    }

}