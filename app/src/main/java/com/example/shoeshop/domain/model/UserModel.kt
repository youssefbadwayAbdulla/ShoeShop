package com.example.shoeshop.domain.model

import java.util.*

data class UserModel(
    val id: String = UUID.randomUUID().toString(),
    val email: String,
    val password: String
)
