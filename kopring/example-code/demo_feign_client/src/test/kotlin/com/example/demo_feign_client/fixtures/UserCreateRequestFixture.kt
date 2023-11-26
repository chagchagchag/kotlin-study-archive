package com.example.demo_feign_client.fixtures

import com.example.demo_feign_client.valueobject.UserCreateRequest
import java.util.*

class UserCreateRequestFixture {

    companion object {
        fun normalRequest(email: String, password: String): UserCreateRequest{
            return UserCreateRequest(
                id = UUID.randomUUID(),
                email = email,
                password = password,
            )
        }
    }

}