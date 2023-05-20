package com.example.composestatemanagementplayground.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composestatemanagementplayground.user.UserViewModel

@Composable
fun Body(
    viewModel: UserViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    var hasError by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.hasError.collect {
            hasError = true
        }
    }

    if (hasError) {
        // TODO: Display Snack bar
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 30.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ButtonController()
        DisplayUsers()
    }
}