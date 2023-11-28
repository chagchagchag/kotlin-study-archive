package com.example.demo_feign_client.valueobject

import java.math.BigInteger

data class PostReadResponse(
    val id: BigInteger,
    val userId: BigInteger,
    val title: String,
    val body: String,
)
