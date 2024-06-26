package com.example.myfinance.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myfinance.presentation.screens.details.DetailScreen
import com.example.myfinance.presentation.screens.mainScreen.MainScreen

@Composable
fun FinanceNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = FinanceScreens.MainScreen.name) {
        composable(FinanceScreens.MainScreen.name) {
            MainScreen(navController = navController)
        }

        val route = FinanceScreens.DetailsScreen.name
        composable("$route/{spent}", arguments = listOf(
            navArgument(name = "id") {
                type = NavType.IntType
            }
        )) { navBack ->
            navBack.arguments?.getInt("id").let { id ->
                DetailScreen(navController = navController, id = id)
            }
        }
    }
}