package com.example.mercariinjetpackcompose.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mercariinjetpackcompose.constant.Constants

@Composable
fun HomePage(navController: NavHostController) {
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            HomeAppBar(navController)
        }
    }
}

@Composable
fun HomeAppBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .height(40.dp)
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
            .padding(start = 15.dp, top = 3.dp, bottom = 3.dp)
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
            imageVector = Icons.Default.AccountBox,
            contentDescription = "Todo List",
            modifier = Modifier
                .size(30.dp)
                .weight(weightValue)
        )
    }
}

