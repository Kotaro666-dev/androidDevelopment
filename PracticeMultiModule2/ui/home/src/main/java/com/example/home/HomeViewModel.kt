package com.example.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    // TODO: Inject UseCase
) : ViewModel() {

    val data = MutableStateFlow(0)

    init {
        data.value = 10
    }
}