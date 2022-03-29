package com.example.mercariinjetpackcompose.views.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RecommendedItemScreen() {
    LazyColumn {
        items(100) {
            Text("おすすめ")
        }
    }
}