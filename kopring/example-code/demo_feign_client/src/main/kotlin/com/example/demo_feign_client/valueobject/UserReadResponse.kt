package com.example.demo_feign_client.valueobject

import java.util.UUID

data class UserReadResponse(
    val id : UUID,
    val name: String
)
