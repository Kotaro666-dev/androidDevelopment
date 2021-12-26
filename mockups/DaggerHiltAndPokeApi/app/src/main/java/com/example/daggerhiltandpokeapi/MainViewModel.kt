package com.example.daggerhiltandpokeapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel() {

    private var _title = MutableLiveData<String>()
    val title: LiveData<String>
        get() = _title

    init {
        _title.value = useCase.getTest()
    }

}