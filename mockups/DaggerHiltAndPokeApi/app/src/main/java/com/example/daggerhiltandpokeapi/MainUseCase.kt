package com.example.daggerhiltandpokeapi

import com.example.daggerhiltandpokeapi.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainUseCase @Inject constructor(
    val repository: Repository
) {

    suspend fun fetchPokemonList() {
        withContext(Dispatchers.IO) {
            repository.fetchPokemon()
            repository.insertAll()
            
        }
    }
}