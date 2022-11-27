package com.example.mercariinjetpackcompose.views.notification

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mercariinjetpackcompose.constant.Constants
import com.example.mercariinjetpackcompose.model.News
import com.example.mercariinjetpackcompose.model.NotificationMessage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun NotificationPage(
    navController: NavHostController,
    viewModel: NotificationPageViewModel = viewModel()
) {
    val notifications by viewModel.notifications.observeAsState(mutableListOf())
    val news by viewModel.news.observeAsState(mutableListOf())
    Scaffold {
        TopPageTabs(notifications = notifications, news = news)
    }
}

@ExperimentalPagerApi
@Composable
fun TopPageTabs(notifications: MutableList<NotificationMessage>, news: MutableList<News>) {
    val tabTitles = listOf("お知らせ", "ニュース")
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(
                        pagerState,
                        tabPositions
                    ),
                    color = Color.Red
                )
            },
        ) {
            tabTitles.forEachIndexed { index, title ->
                val isSelected = pagerState.currentPage == index
                val isLeaningTowardsNotificationTab =
                    (pagerState.currentPage == index && pagerState.currentPageOffset < 0.5F)
                            || (pagerState.currentPage != index && pagerState.currentPageOffset < -0.5F)
                val isLeaningTowardsNewsTab =
                    (pagerState.currentPage != index && 0.5F < pagerState.currentPageOffset)
                            || (pagerState.currentPage == index && -0.5F < pagerState.currentPageOffset)
                val isTabFocused =
                    (index == Constants.NOTIFICATION_PAGE_NOTIFICATION_TAB_INDEX && isLeaningTowardsNotificationTab)
                            || (index == Constants.NOTIFICATION_PAGE_NEWS_TAB_INDEX && isLeaningTowardsNewsTab)
                Tab(
                    selected = isSelected,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            title,
                            color = if (isTabFocused) Color.Red else Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
        }
        HorizontalPager(count = tabTitles.size, state = pagerState) { index ->
            when (index) {
                0 -> NotificationTabPage(notifications)
                1 -> NewsTabPage(news)
            }
        }
    }
}

@Composable
fun NotificationTabPage(notifications: MutableList<NotificationMessage>) {
    LazyColumn {
        items(notifications.size) { index ->
            NotificationMessageItem(notifications[index])
            Divider(
                color = Color.Gray,
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 70.dp, end = 20.dp)
            )
        }
    }
}

@Composable
fun NotificationMessageItem(notification: NotificationMessage) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        ItemImage(notification.imageUrl)
        ItemDescription(notification.date, notification.description)
    }
}

@Composable
fun ItemImage(imageUrl: String) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .width(80.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Item Image"
        )
    }
}

@Composable
fun ItemDescription(date: String, description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Date(date)
        Text(description, modifier = Modifier.padding(end = 20.dp))
    }
}

@Composable
fun NewsTabPage(news: MutableList<News>) {
    LazyColumn {
        items(news.size) { index ->
            NewsItem(description = news[index].description, date = news[index].date)
            Divider(
                color = Color.Gray,
                thickness = 0.5.dp,
            )
        }
    }
}

@Composable
fun NewsItem(description: String, date: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 10.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(description)
            Date(date)
        }
    }
}

@Composable
fun Date(text: String) {
    Row(
        modifier = Modifier.height(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.AccessTime,
            contentDescription = "Date",
            tint = Color.Gray,
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text(text, color = Color.Gray, fontSize = 12.sp)
    }
}