package com.example.mercariinjetpackcompose.views.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mercariinjetpackcompose.constant.Constants
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun HomePage(navController: NavHostController, viewModel: HomePageViewModel = viewModel()) {
    val categories by viewModel.categories.observeAsState(mutableListOf())
    val initialPage: Int by viewModel.initialPage.observeAsState(0)
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            HomeAppBar(navController)
            CategoriesField(categories = categories, initialPage = initialPage)
        }
    }
}

@Composable
fun HomeAppBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SearchFieldButton(weightValue = 6f, navController = navController)
        TodoListIconButton(weightValue = 1f, navController = navController)
    }
}

@Composable
fun RowScope.SearchFieldButton(weightValue: Float, navController: NavHostController) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .weight(weightValue)
            .padding(start = 15.dp, top = 8.dp, bottom = 8.dp)
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable(
                onClick = {
                    navController.navigate(Constants.SEARCH_ROUTE_PAGE)
                },
                interactionSource = interactionSource,
                indication = null
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "なにをお探しですか？", color = Color.Gray)
    }
}

@Composable
fun RowScope.TodoListIconButton(
    weightValue: Float,
    navController: NavHostController
) {
    IconButton(
        onClick = {
            navController.navigate(Constants.TODO_LIST_ROUTE_PAGE)
        }) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Todo List",
            modifier = Modifier
                .size(30.dp)
                .weight(weightValue)
        )
    }
}

@ExperimentalPagerApi
@Composable
fun CategoriesField(categories: List<String>, initialPage: Int) {
    val pagerState = rememberPagerState(initialPage)
    val scope = rememberCoroutineScope()
    Column {
        ScrollableTabRow(
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
            modifier = Modifier
                .height(50.dp)
        ) {
            categories.forEachIndexed { index, category ->
                val isSelected = pagerState.currentPage == index
                Tab(
                    selected = isSelected,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {
                    Text(
                        text = category,
                        color = if (index == pagerState.currentPage) Color.Red else Color.Black,
                    )
                }
            }
        }
        HorizontalPager(count = categories.size, state = pagerState) { index ->
            when (index % 3) {
                0 -> RecommendedItemScreen()
                1 -> ShopScreen()
                2 -> SavedSearchConditionScreen()
            }
        }
    }
}

