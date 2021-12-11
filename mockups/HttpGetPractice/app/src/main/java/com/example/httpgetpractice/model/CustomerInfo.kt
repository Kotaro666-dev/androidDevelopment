package com.example.httpgetpractice.model

data class CustomerInfo(
    val id: Int,
    val name: String,
    val accountNumber: String,
    val isLoggedIn: Boolean,
    val depositNumber: Int,
)