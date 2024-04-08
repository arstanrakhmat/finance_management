package com.example.myfinance.presentation.navigation

enum class FinanceScreens {
    MainScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String): FinanceScreens =
            when (route.substringBefore("/")) {
                MainScreen.name -> MainScreen
                DetailsScreen.name -> DetailsScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
    }
}