package com.example.myfinance.screens.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, spend: String?) {
    Text(text = spend.toString())
}