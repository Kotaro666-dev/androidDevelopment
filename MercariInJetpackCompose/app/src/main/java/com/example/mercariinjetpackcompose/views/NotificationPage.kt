package com.example.mercariinjetpackcompose.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@Composable
fun NotificationPage(navController: NavHostController) {
    Scaffold {
        LazyColumn {
            items(100) {
                NotificationMessageItem()
                Divider(
                    color = Color.Gray,
                    thickness = 0.5.dp,
                    modifier = Modifier.padding(start = 70.dp, end = 20.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun NotificationMessageItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        ItemImage()
        ItemDescription()
    }
}

@Composable
fun ItemImage() {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .width(80.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "https://via.placeholder.com/120",
            contentDescription = "Item Image"
        )
    }
}

@Composable
fun ItemDescription() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        // 日にち
        Row(
            modifier = Modifier.height(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.AccessTime,
                contentDescription = "Time",
                tint = Color.Gray,
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text("1日前", color = Color.Gray, fontSize = 12.sp)
        }
        // コメント内容
        Text("いいね！した「「ラストチャンス」○○」にコメントがつきました", modifier = Modifier.padding(end = 20.dp))
    }
}