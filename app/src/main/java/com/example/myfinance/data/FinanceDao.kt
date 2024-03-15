package com.example.myfinance.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myfinance.model.FinanceInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface FinanceDao {

    @Query("SELECT * FROM finance_tbl")
    fun getAllFinanceInfo() : Flow<List<FinanceInfo>>

    @Query("SELECT * FROM finance_tbl WHERE isIncome == false")
    fun getIncomeList() : Flow<List<FinanceInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIncome(financeInfo: FinanceInfo)

    @Delete
    fun deleteIncome(financeInfo: FinanceInfo)
}