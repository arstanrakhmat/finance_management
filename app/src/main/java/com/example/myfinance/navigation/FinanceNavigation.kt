package com.example.myfinance.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myfinance.screens.details.DetailScreen
import com.example.myfinance.screens.mainScreen.MainScreen

@Composable
fun FinanceNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = FinanceScreens.MainScreen.name) {
        composable(FinanceScreens.MainScreen.name) {
            MainScreen(navController = navController)
        }

        val route = FinanceScreens.DetailsScreen.name
        composable("$route/{spent}", arguments = listOf(
            navArgument(name = "spent") {
                type = NavType.StringType
            }
        )) { navBack ->
            navBack.arguments?.getString("spent").let { spent ->
                DetailScreen(navController = navController, spend = spent)
            }
        }
    }
}