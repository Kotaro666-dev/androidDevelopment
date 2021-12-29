package com.example.daggerhiltandpokeapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.daggerhiltandpokeapi.database.MyDatabase
import com.example.daggerhiltandpokeapi.model.PokeApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Repository @Inject constructor(
    private val pokemonStore: PokemonStore,
    private val database: MyDatabase,
) {
    companion object {
        private const val BASE_URL = "https://pokeapi.co"
        private const val NUMBER_OF_POKEMON = 100
    }

    private val tempList = mutableListOf<Pokemon>()

    private val _pokemonList = MutableLiveData<MutableList<Pokemon>>()
    val pokemonList: LiveData<MutableList<Pokemon>>
        get() = _pokemonList

    private val _isError = MutableLiveData<Boolean>()
    val isError: LiveData<Boolean>
        get() = _isError

    suspend fun fetchPokemon() {
        val service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)

        withContext(Dispatchers.IO) {
            for (index in 1..NUMBER_OF_POKEMON) {
                try {
                    val response = service.getPokemon(index.toString())
                    if (response.isSuccessful) {
                        parsePokemon(response.body())
                    }
                } catch (exception: IOException) {
                    _isError.postValue(true)
                    exception.printStackTrace()
                    break
                }
            }
        }
        _pokemonList.postValue(tempList)
    }

    suspend fun insertAll() {
        if (_pokemonList.value == null) {
            return
        }
        withContext(Dispatchers.IO) {
            database.pokemonDatabase.insertAll(_pokemonList.value!!)
        }
    }

    suspend fun getAll(): List<Pokemon> {
        var pokemonList: List<Pokemon>
        withContext(Dispatchers.IO) {
            pokemonList = database.pokemonDatabase.getAll()
        }
        return pokemonList
    }

    private fun parsePokemon(pokemonApiModel: PokeApiModel?) {
        if (pokemonApiModel != null) {
            val pokemon = Pokemon(
                id = pokemonApiModel.id ?: 0,
                name = pokemonApiModel.name ?: "",
                imageUrl = pokemonApiModel.sprites.front_default ?: ""
            )
            tempList.add(pokemon)
        }
    }
}