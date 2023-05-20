package com.example.composestatemanagementplayground.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composestatemanagementplayground.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _userState = MutableStateFlow(UserState())
    val userState: StateFlow<UserState> = _userState.asStateFlow()

    fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _userState.value = _userState.value.copy(loadingState = LoadingState.LOADING)
            try {
                userRepository.fetchAll().collect { users ->
                    _userState.value = _userState.value.copy(
                        users = users,
                        loadingState = LoadingState.LOADED
                    )
                    println(_userState.value)
                }
            } catch (_: Exception) {
                _userState.value = _userState.value.copy(
                    loadingState = LoadingState.LOADED,
                    hasError = true,
                )
            }

        }
    }

    fun reset() {
        _userState.value = _userState.value.copy(users = listOf())
    }
}