package com.example.daggerhiltandpokeapi.repository

import com.example.daggerhiltandpokeapi.model.PokeApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("/api/v2/pokemon/{index}")
    suspend fun getPokemon(
        @Path("index") index: String,
    ): Response<PokeApiModel>
}