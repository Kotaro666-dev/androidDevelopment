package com.example.okhttpretryrequestsample.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.okhttpretryrequestsample.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var _catFact = MutableLiveData<String>()
    val catFact: LiveData<String>
        get() = _catFact

    private val repository = Repository()

    fun requestApi() {
        viewModelScope.launch {
            _catFact.value = repository.getText()
        }
    }
}