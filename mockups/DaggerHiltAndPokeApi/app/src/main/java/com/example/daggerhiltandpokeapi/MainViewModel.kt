package com.example.daggerhiltandpokeapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltandpokeapi.repository.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel() {

    private var _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>>
        get() = _pokemonList

    private fun getPokemonList() {
        viewModelScope.launch {
            _pokemonList.value = useCase.getPokemonList()
            println(_pokemonList.value)
        }
    }

    init {
        getPokemonList()
    }

}