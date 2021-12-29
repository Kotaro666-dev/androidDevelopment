package com.example.daggerhiltandpokeapi

import androidx.fragment.app.FragmentManager
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
    private val useCase: MainUseCase,
    private val coordinator: MainCoordinator
) : ViewModel() {

    private var _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>>
        get() = _pokemonList

    private val _isError = useCase.repository.isError
    val isError: LiveData<Boolean>
        get() = _isError

    fun fetchPokemonList(fragmentManager: FragmentManager) {
        viewModelScope.launch {
            coordinator.displayDialogIndicator(fragmentManager)
            useCase.fetchPokemonList()
            updatePokemonList()
            coordinator.dismissDialogIndicator()
        }
    }

    private fun updatePokemonList() {
        _pokemonList.value = useCase.repository.pokemonList.value
    }
}