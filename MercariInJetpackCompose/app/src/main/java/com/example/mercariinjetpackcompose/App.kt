package com.example.mercariinjetpackcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mercariinjetpackcompose.constant.Constants
import com.example.mercariinjetpackcompose.views.*
import com.example.mercariinjetpackcompose.views.home.HomePage
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    // ここでボトムバーの表示/非表示の切替を行う
    // 参考資料：https://github.com/AndreiRoze/BottomBarAnimation/blob/with_animated_topbar/app/src/main/java/codes/andreirozov/bottombaranimation/MainActivity.kt
    when (navBackStackEntry?.destination?.route) {
        Constants.SEARCH_ROUTE_PAGE -> {
            bottomBarState.value = false
        }
        Constants.TODO_LIST_ROUTE_PAGE -> {
            bottomBarState.value = false
        }
        else -> {
            if (!bottomBarState.value) {
                bottomBarState.value = true
            }
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, bottomBarState = bottomBarState)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) { HomePage(navController) }
            composable(Screen.Notification.route) { NotificationPage(navController) }
            composable(Screen.Post.route) { PostPage(navController) }
            composable(Screen.Merpay.route) { MerpayPage(navController) }
            composable(Screen.MyPage.route) { MyPage(navController) }
            composable(Screen.SearchPage.route) { SearchPage(navController) }
            composable(Screen.TodoListPage.route) { TodoListPage(navController) }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, bottomBarState: MutableState<Boolean>) {
    val bottomTabBarItems = listOf(
        Screen.Home,
        Screen.Notification,
        Screen.Post,
        Screen.Merpay,
        Screen.MyPage
    )
    AnimatedVisibility(
        visible = bottomBarState.value,
        content = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                bottomTabBarItems.forEach { screen ->
                    val iconImageVector =
                        if (currentRoute == screen.route) screen.selectedIcon else screen.defaultIcon
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = iconImageVector!!,
                                contentDescription = screen.route,
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
                        selected = currentRoute == screen.route,
                        onClick = {
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
                        }
                    )
                }
            }
        }
    )
}
