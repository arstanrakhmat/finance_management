package com.example.myfinance.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myfinance.screens.mainScreen.MainScreen

@Composable
fun FinanceNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = FinanceScreens.MainScreen.name) {
        composable(FinanceScreens.MainScreen.name) {
            MainScreen(navController = navController)
        }
    }
}