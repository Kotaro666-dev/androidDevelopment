package com.example.composestatemanagementplayground.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestatemanagementplayground.model.User
import com.example.composestatemanagementplayground.ui.theme.ComposeStateManagementPlaygroundTheme

@Composable
fun DisplayUser(user: User, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(
                BorderStroke(2.dp, SolidColor(Color.Black))
            )
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {
        Text("Name: ${user.name}")
        Text("Age: ${user.age}")
        Text("Country: ${user.country}")
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayUserPreview() {
    ComposeStateManagementPlaygroundTheme {
        DisplayUser(user = User(name = "Adam", age = 28, country = "United States"))
    }
}