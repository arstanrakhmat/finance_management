package com.example.myfinance.domain

import com.example.myfinance.data.database.Type

data class FinanceInfo(
    val id: Int = 0,
    val amount: Int,
    val dt: Int,
    val comment: String,
    val isIncome: Boolean,
    val type: Type
)
