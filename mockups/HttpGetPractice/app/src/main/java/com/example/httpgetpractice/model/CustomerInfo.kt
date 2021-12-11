package com.example.httpgetpractice.model

data class CustomerInfo(
    val id: Long,
    val name: String,
    val accountNumber: String,
    val isLoggedIn: Boolean,
    val depositAmount: Int,
)