package com.example.myfinance.domain

import kotlinx.coroutines.flow.Flow

interface FinanceRepository {

    fun getFinanceInfoList(): Flow<List<FinanceInfo>>

    fun getIncomeFinanceInfoList(): Flow<List<FinanceInfo>>

    fun getOneFinanceInfoItem(id: Int): FinanceInfo
}