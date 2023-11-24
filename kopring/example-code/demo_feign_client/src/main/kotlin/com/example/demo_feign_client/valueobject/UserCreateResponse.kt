package com.example.demo_feign_client.valueobject

import java.util.*

data class UserCreateResponse(
    val id: UUID,
    val email: String,
    val password: String
)
