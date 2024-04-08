package com.example.myfinance.presentation.screens.mainScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myfinance.R
import com.example.myfinance.presentation.screens.mainScreen.expenses.ExpensesScreen
import com.example.myfinance.presentation.screens.mainScreen.goal.GoalsScreen
import com.example.myfinance.presentation.screens.mainScreen.income.IncomeScreen
import com.example.myfinance.presentation.screens.mainScreen.mooneyLeft.MooneyLeftScreen

@Composable
fun MainScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.main_bg_top_color)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        DateRange()
        TabLayout(navController = navController)
    }
}

@Composable
fun DateRange() {
    Surface(
        color = colorResource(id = R.color.date_range_bg),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(60.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_calendar),
                contentDescription = "calendar image"
            )
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "с 01.07.2023 по 01.08.2023",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(navController: NavController) {
    val titles = listOf("Остаток", "Доходы", "Расходы", "Цели")
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        titles.size
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

    Column {
        TabRow(
            containerColor = colorResource(id = R.color.main_bg_top_color),
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                if (selectedTabIndex < tabPositions.size) {
                    SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = colorResource(id = R.color.row_indicator)
                    )
                }
            }
        ) {
            titles.forEachIndexed { index, s ->
                Tab(
                    selected = index == selectedTabIndex, onClick = {
                        selectedTabIndex = index
                    },
                    text = { Text(text = s) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = colorResource(id = R.color.unselected_item_row_indicator)
                )
            }
        }

        //Horizontal pager
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            when (index) {
                0 -> MooneyLeftScreen(navController = navController)
                1 -> IncomeScreen()
                2 -> ExpensesScreen()
                3 -> GoalsScreen()
            }
        }
    }
}