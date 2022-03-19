package com.example.mercariinjetpackcompose

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mercariinjetpackcompose.constant.Constants

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home : Screen(Constants.HOME_SCREEN_ROUTE_NAME, R.string.home, Icons.Default.Home)
    object Notification : Screen(
        Constants.NOTIFICATION_SCREEN_ROUTE_NAME,
        R.string.notification,
        Icons.Filled.Notifications
    )

    object Post : Screen(Constants.POST_SCREEN_ROUTE_NAME, R.string.post, Icons.Default.Phone)
    object Merpay :
        Screen(Constants.MERPAY_SCREEN_ROUTE_NAME, R.string.merpay, Icons.Default.AccountBox)

    object MyPage :
        Screen(Constants.MY_PAGE_SCREEN_ROUTE_NAME, R.string.my_page, Icons.Default.Person)
}