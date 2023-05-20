package com.example.composestatemanagementplayground.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composestatemanagementplayground.view.user.LoadingState
import com.example.composestatemanagementplayground.view.user.UserViewModel

@Composable
fun Body(
    viewModel: UserViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val state = viewModel.userState.collectAsState().value
    val isLoading = state.loadingState == LoadingState.LOADING
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(onClick = {
            viewModel.fetchUsers()
        }) {
            Text("Fetch Users data")
        }
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            state.users.forEach {
                DisplayUser(user = it)
            }
        }
        OutlinedButton(onClick = {
            viewModel.reset()
        }) {
            Text("Reset")
        }
    }
}