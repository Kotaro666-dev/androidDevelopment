package com.example.textfieldfocusinjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.textfieldfocusinjetpackcompose.ui.theme.TextFieldFocusInJetpackComposeTheme

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldFocusInJetpackComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home_screen") {
                    composable("home_screen") { HomeScreen(navController) }
                    composable("search_screen") { SearchScreen(navController) }
                    /*...*/
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text("ホーム画面")
            Button(onClick = { navController.navigate("search_screen") }) {
                Text("検索画面")
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun SearchScreen(navController: NavController) {
    val interactionSource = remember { MutableInteractionSource() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    DisposableEffect(Unit) {
        onDispose {
            keyboardController?.hide()
            focusManager.clearFocus(true)
        }
    }

    Scaffold(
        topBar = { SearchBar(navController = navController) },
        modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
        ) {
            keyboardController?.hide()
            focusManager.clearFocus(true)
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text("検索画面")
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun SearchBar(navController: NavController) {
    var text by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    TopAppBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    keyboardController?.hide()
                    focusManager.clearFocus(true)
                    navController.popBackStack()
                },
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go back",
                    modifier = Modifier
                        .size(30.dp),
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        modifier = Modifier
                            .size(30.dp),
                        tint = Color.White
                    )
                },
                placeholder = { Text("キーワードからさがす", color = Color.White.copy(alpha = 0.5f)) },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.White,
                ),
                maxLines = 1,
                value = text,
                onValueChange = { newValue -> text = newValue },
            )
        }
    }
}