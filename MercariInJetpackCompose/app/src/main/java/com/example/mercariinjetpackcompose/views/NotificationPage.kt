package com.example.mercariinjetpackcompose.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mercariinjetpackcompose.constant.Constants
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun NotificationPage(navController: NavHostController) {
    Scaffold {
        TopPageTabs()
    }
}

@ExperimentalPagerApi
@Composable
fun TopPageTabs() {
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
                            color = if (
                                (index == Constants.NOTIFICATION_PAGE_NOTIFICATION_TAB_INDEX && isLeaningTowardsNotificationTab)
                                || (index == Constants.NOTIFICATION_PAGE_NEWS_TAB_INDEX && isLeaningTowardsNewsTab)
                            ) Color.Red else Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
        }
        HorizontalPager(count = tabTitles.size, state = pagerState) { index ->
            when (index) {
                0 -> NotificationTabPage()
                1 -> NewsTabPage()
            }
        }
    }
}

@Composable
fun NotificationTabPage() {
    LazyColumn {
        items(100) {
            NotificationMessageItem()
            Divider(
                color = Color.Gray,
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 70.dp, end = 20.dp)
            )
        }
    }
}

@Preview
@Composable
fun NotificationMessageItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        ItemImage()
        ItemDescription()
    }
}

@Composable
fun ItemImage() {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .width(80.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "https://via.placeholder.com/120",
            contentDescription = "Item Image"
        )
    }
}

@Composable
fun ItemDescription() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Date("1日前")
        Text("いいね！した「「ラストチャンス」○○」にコメントがつきました", modifier = Modifier.padding(end = 20.dp))
    }
}

@Composable
fun NewsTabPage() {
    LazyColumn {
        items(100) {
            NewsItem()
            Divider(
                color = Color.Gray,
                thickness = 0.5.dp,
            )
        }
    }
}

@Composable
fun NewsItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(start = 10.dp, end = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("【3/19 10:00 追記】「東北地方を中心とする地震」に伴う配送遅延について")
            Date("2022/03/18 10:00")
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