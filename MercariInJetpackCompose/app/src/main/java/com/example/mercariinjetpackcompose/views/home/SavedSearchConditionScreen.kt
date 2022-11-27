package com.example.mercariinjetpackcompose.views.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SavedSearchConditionScreen() {
    LazyColumn {
        items(100) {
            Text("検索した保存条件")
        }
    }
}