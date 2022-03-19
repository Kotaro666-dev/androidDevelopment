package com.example.mercariinjetpackcompose

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mercariinjetpackcompose.constant.Constants

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val defaultIcon: ImageVector,
    val selectedIcon: ImageVector
) {
    object Home : Screen(
        Constants.HOME_SCREEN_ROUTE_NAME,
        R.string.home,
        Icons.Outlined.Home,
        Icons.Filled.Home
    )

    object Notification : Screen(
        Constants.NOTIFICATION_SCREEN_ROUTE_NAME,
        R.string.notification,
        Icons.Outlined.Notifications,
        Icons.Filled.Notifications,
    )

    object Post :
        Screen(
            Constants.POST_SCREEN_ROUTE_NAME,
            R.string.post,
            Icons.Outlined.PhotoCamera,
            Icons.Filled.PhotoCamera
        )

    object Merpay :
        Screen(
            Constants.MERPAY_SCREEN_ROUTE_NAME,
            R.string.merpay,
            Icons.Outlined.QrCode,
            Icons.Filled.QrCode
        )

    object MyPage :
        Screen(
            Constants.MY_PAGE_SCREEN_ROUTE_NAME,
            R.string.my_page,
            Icons.Outlined.Person,
            Icons.Filled.Person
        )
}