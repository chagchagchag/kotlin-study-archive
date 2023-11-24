package com.example.demo_feign_client.valueobject

import java.util.UUID

data class UserCreateRequest(
    val id: UUID,
    val email: String,
    val password: String,
)