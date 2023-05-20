package com.example.composestatemanagementplayground.view.user

import com.example.composestatemanagementplayground.model.User

data class UserState(
    val users: List<User> = emptyList(),
    val loadingState: LoadingState = LoadingState.IDLE,
    val hasError: Boolean = false
)

enum class LoadingState {
    IDLE,
    LOADING,
    LOADED,
}