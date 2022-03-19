package com.example.mercariinjetpackcompose

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mercariinjetpackcompose.views.*

@Composable
fun App() {
    val navController = rememberNavController()
    val bottomTabBarItems = listOf(
        Screen.Home,
        Screen.Notification,
        Screen.Post,
        Screen.Merpay,
        Screen.MyPage
    )
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                bottomTabBarItems.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = screen.route
                            )
                        },
                        label = {
                            val density = LocalDensity.current
                            Text(
                                stringResource(screen.resourceId),
                                softWrap = false,
                                fontSize = with(density) { 10.dp.toSp() }
                            )
                        },
                        selected = currentRoute == screen.route, onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it) {
                                        saveState = true
                                    }
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        })
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Notification.route
        ) {
            composable(Screen.Home.route) { HomePage(navController) }
            composable(Screen.Notification.route) { NotificationPage(navController) }
            composable(Screen.Post.route) { PostPage(navController) }
            composable(Screen.Merpay.route) { MerpayPage(navController) }
            composable(Screen.MyPage.route) { MyPage(navController) }
        }
    }
}
