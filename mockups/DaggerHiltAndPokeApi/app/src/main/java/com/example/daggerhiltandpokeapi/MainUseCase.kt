package com.example.daggerhiltandpokeapi

import com.example.daggerhiltandpokeapi.repository.Pokemon
import com.example.daggerhiltandpokeapi.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun getPokemonList(): List<Pokemon> {
        var pokemonList: List<Pokemon>
        withContext(Dispatchers.IO) {
            pokemonList = repository.fetchPokemon()
        }
        return pokemonList
    }
}