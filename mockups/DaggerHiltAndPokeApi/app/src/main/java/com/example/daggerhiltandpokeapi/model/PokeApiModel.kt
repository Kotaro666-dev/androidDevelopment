package com.example.daggerhiltandpokeapi.model

import com.google.gson.annotations.SerializedName

data class PokeApiModel(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("sprites")
    val sprites: Sprites,
)

data class Sprites(
    @SerializedName("front_default")
    val front_default: String?,
)
