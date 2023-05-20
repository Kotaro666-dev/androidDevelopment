package com.example.composestatemanagementplayground.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composestatemanagementplayground.user.UserViewModel

@Composable
fun ButtonController(
    viewModel: UserViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedButton(onClick = {
            viewModel.fetchUsers()
        }) {
            Text("Fetch Users data")
        }
        OutlinedButton(onClick = {
            viewModel.reset()
        }) {
            Text("Reset")
        }
    }
}