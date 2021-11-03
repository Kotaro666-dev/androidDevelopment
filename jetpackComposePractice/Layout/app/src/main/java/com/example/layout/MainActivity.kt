package com.example.layout

import android.graphics.drawable.Icon
import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layout.ui.theme.LayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutTheme {
                LayoutCodeLab()
            }
        }
    }
}

@Composable
fun LayoutCodeLab() {
    Scaffold(
        topBar = {
            TopAppBar()
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
        BodyContent(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun BottomNavigationBar() {
    BottomAppBar {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            BottomNavigationBarItem(
                onClick = {},
                title = "Home",
                iconAsset = Icons.Filled.Home
            )
            BottomNavigationBarItem(
                onClick = {},
                title = "Search",
                iconAsset = Icons.Filled.Search
            )
            BottomNavigationBarItem(
                onClick = {},
                title = "Settings",
                iconAsset = Icons.Filled.Settings
            )
        }
    }
}

@Composable
fun BottomNavigationBarItem(onClick: () -> Unit, title: String, iconAsset: ImageVector) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = onClick, modifier = Modifier.size(24.dp)) {
            Icon(iconAsset, contentDescription = null)
        }
        Text(text = title)
    }
}

@Composable
fun TopAppBar() {
    TopAppBar(
        title = {
            Text(text = "LayoutCodelab")
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.Favorite, contentDescription = null,
                    tint = Color.White
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
    )
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        LayzColumnList()
    }
}

@Composable
fun LayzColumnList() {
    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState
    ) {
        items(100) {
            Text(text = "Item #$it")
        }
    }
}

@Preview
@Composable
fun LayoutCodeLabPreview() {
    LayoutTheme {
        LayoutCodeLab()
    }

//@Composable
//fun PhotographerCard() {
//    Row(
//        modifier = Modifier
//            .padding(8.dp)
//            .clip(RoundedCornerShape(4.dp))
//            .background(MaterialTheme.colors.surface)
//            .clickable(onClick = {})
//            .padding(16.dp)
//    ) {
//        Surface(
//            modifier = Modifier.size(50.dp),
//            shape = CircleShape,
//            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
//        ) {
//            // Image goes here
//        }
//        Column(
//            modifier = Modifier
//                .padding(start = 8.dp)
//                .align(alignment = Alignment.CenterVertically)
//        ) {
//            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
//            // LocalContentAlpha is defining opacity level of its children
//            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
//                Text("3 minutes ago", style = MaterialTheme.typography.body2)
//            }
//        }
//    }
//
//}
//
//@Preview
//@Composable
//fun PhotographerCardPreview() {
//    LayoutTheme {
//        PhotographerCard()
//    }
}