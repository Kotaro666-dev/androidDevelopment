package com.example.jetpackcomposebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val names: List<String> = listOf("World", "Compose")
        setContent {
            JetpackComposeBasicsTheme {
                MyApp(names = names)
            }
        }
    }
}

@Composable
private fun MyApp(names: List<String>) {
    var shouldShowOnBoarding by remember { mutableStateOf(true) }
    Surface(color = MaterialTheme.colors.background) {
        if (shouldShowOnBoarding) {
            OnBoardingScreen(onClickAction = {shouldShowOnBoarding = false})
        } else {
            Greeting("Android")
            Column {
                for (name in names) {
                    Greeting(name = name)
                }
                Button(
                    onClick = { shouldShowOnBoarding = true },
                ) {
                    Text("Go back")
                }
            }
        }

//
    }
}

@Composable
fun Greeting(name: String) {
    val expanded = remember { mutableStateOf(false)}

    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text( if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    val names: List<String> = listOf("World", "Compose")
    JetpackComposeBasicsTheme {
        MyApp(names = names)
    }
}

@Composable
fun OnBoardingScreen(onClickAction: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onClickAction
            ) {
                Text("Continue")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingPreview() = JetpackComposeBasicsTheme {
    OnBoardingScreen(onClickAction = {})
}