package com.example.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.layout.ui.theme.LayoutTheme
import kotlinx.coroutines.launch

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
    MyOwnColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        ScrollingList()
    }
}

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        // Don't constrain child views further, measure them with given constraints
        // List of measured children
        val placeables = measurables.map { measurable ->
            // Measure each child
            measurable.measure(constraints)
        }

        // Track the y co-ord we have placed children up to
        var yPosition = 0

        // Set the size of the layout as big as it can
        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = yPosition)

                // Record the y co-ord placed up to
                yPosition += placeable.height
            }
        }
    }
}

@Composable
fun ScrollingList() {
    val listSize = 100
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        ListControlButtons(
            onClickGoToTopButton = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }, onClickGoToBottomButton = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            })

        LazyColumn(
            state = scrollState
        ) {
            items(100) {
                ImageListItem(index = it)
            }
        }
    }
}

@Composable
fun ListControlButtons(onClickGoToTopButton: () -> Unit, onClickGoToBottomButton: () -> Unit) {
    Row {
        Button(onClick = onClickGoToTopButton) {
            Text("Scroll to the top")
        }
        Button(onClick = onClickGoToBottomButton) {
            Text("Scroll to the end")
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
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