package com.example.myfinance.presentation.screens.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, id: Int?) {
    Text(text = id.toString())
}