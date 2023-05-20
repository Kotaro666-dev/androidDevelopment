package com.example.composestatemanagementplayground.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composestatemanagementplayground.model.User
import com.example.composestatemanagementplayground.view.user.UserViewModel

@Composable
fun Body(
    viewModel: UserViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val user1 =
        User(name = "Adam", age = 28, country = "United States")
    val user2 =
        User(name = "John", age = 31, country = "United Kingdom")
    val user3 =
        User(name = "Ana", age = 28, country = "Spain")
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
        DisplayUser(user = user1)
        DisplayUser(user = user2)
        DisplayUser(user = user3)
        OutlinedButton(onClick = {
            viewModel.reset()
        }) {
            Text("Reset")
        }
    }
}