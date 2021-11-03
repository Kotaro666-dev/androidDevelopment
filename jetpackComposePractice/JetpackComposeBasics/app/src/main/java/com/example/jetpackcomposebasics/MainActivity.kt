package com.example.jetpackcomposebasics

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposebasics.ui.theme.JetpackComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val names: List<String> = listOf("World", "Compose")
        val names: List<String> = List(1000) { "$it" }
        setContent {
            JetpackComposeBasicsTheme {
                MyApp(names = names)
            }
        }
    }
}

@Composable
private fun MyApp(names: List<String>) {
    var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }
    Surface(color = MaterialTheme.colors.background) {
        if (shouldShowOnBoarding) {
            OnBoardingScreen(onClickAction = {shouldShowOnBoarding = false})
        } else {
            LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
                items(items = names) { name ->
                    CardContent(name = name)
                }
            }

//            Column{
//                Greeting("Android")
//                Button(
//                    onClick = { shouldShowOnBoarding = true },
//                ) {
//                    Text("Go back")
//                }
//            }

//            Column {
//                for (name in names) {
//                    Greeting(name = name)
//                }
//            }
        }

//
    }
}

@Composable
fun CardContent(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false)}

//    val extraPadding by animateDpAsState(
//        if (expanded) 48.dp else 0.dp,
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioMediumBouncy,
//            stiffness = Spring.StiffnessLow
//        )
//    )

    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(12.dp).animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(12.dp)) {
                Text(text = "Hello, ")
                Text(text = name, style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.ExtraBold
                ))
                if (expanded) Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tortor risus, rutrum ac lobortis id, ullamcorper a lacus. Vestibulum lobortis.")
            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) {
                        stringResource(R.string.show_less)
                    } else {
                        stringResource(R.string.show_more)
                    }

                )
            }
//            OutlinedButton(
//                onClick = { expanded = !expanded }
//            ) {
//                Text( if (expanded) "Show less" else "Show more")
//            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark")
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