package com.example.myfinance.data.repository

import com.example.myfinance.data.database.FinanceDao
import com.example.myfinance.data.mapper.FinanceMapper
import com.example.myfinance.domain.FinanceInfo
import com.example.myfinance.domain.FinanceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FinanceRepositoryImpl(private val financeDao: FinanceDao) : FinanceRepository {

    private val mapper = FinanceMapper()
    override fun getFinanceInfoList(): Flow<List<FinanceInfo>> {
        return financeDao.getAllFinanceInfo()
            .map { value ->
                value.map { mapper.mapDbModelToEntity(it) }
            }
    }

    override fun getIncomeFinanceInfoList(): Flow<List<FinanceInfo>> {
        return financeDao.getIncomeList()
            .map { incomeList ->
                incomeList.map { mapper.mapDbModelToEntity(it) }
            }
    }


}