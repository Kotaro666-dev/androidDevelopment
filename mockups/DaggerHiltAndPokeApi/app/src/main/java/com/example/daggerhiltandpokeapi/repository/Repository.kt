package com.example.daggerhiltandpokeapi.repository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val pokemonStore: PokemonStore
) {
    fun getTest(): String {
        return pokemonStore.test
    }
}