package com.example.demo_feign_client.rest

import com.example.demo_feign_client.valueobject.UserCreateRequest
import com.example.demo_feign_client.valueobject.UserCreateResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @PostMapping("/user")
    fun createUser(
        @RequestBody userCreateRequest: UserCreateRequest
    ): UserCreateResponse {
        return UserCreateResponse(
            userCreateRequest.id,
            userCreateRequest.email,
            userCreateRequest.password,
        )
    }

}