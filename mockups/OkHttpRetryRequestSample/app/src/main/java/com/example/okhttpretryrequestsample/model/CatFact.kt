package com.example.okhttpretryrequestsample.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatFact(
    val fact: String,
    val length: Int
)