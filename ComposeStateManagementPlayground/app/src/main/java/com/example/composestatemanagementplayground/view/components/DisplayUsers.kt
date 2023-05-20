package com.example.composestatemanagementplayground.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composestatemanagementplayground.user.LoadingState
import com.example.composestatemanagementplayground.user.UserViewModel

@Composable
fun DisplayUsers(
    viewModel: UserViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val state = viewModel.userState.collectAsState().value
    val isLoading = state.loadingState == LoadingState.LOADING
    val verticalArrangement =
        if (isLoading) Arrangement.Center else Arrangement.spacedBy(
            space = 10.dp,
            alignment = Alignment.Top
        )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        verticalArrangement = verticalArrangement,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        if (isLoading) {
            item { CircularProgressIndicator() }
        } else {
            state.users.forEach {
                item { DisplayUser(user = it) }
            }
        }
    }
}