package com.example.home

import androidx.lifecycle.ViewModel
import com.example.domain.home.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeUseCase: HomeUseCase,
) : ViewModel() {

    val message = MutableStateFlow("")

    init {
        message.value = homeUseCase.getValue();
    }
}