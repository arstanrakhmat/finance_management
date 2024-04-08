package com.example.myfinance.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FinanceDao {

    @Query("SELECT * FROM finance_tbl")
    fun getAllFinanceInfo() : Flow<List<FinanceInfoDbModel>>

    @Query("SELECT * FROM finance_tbl WHERE isIncome == false")
    fun getIncomeList() : Flow<List<FinanceInfoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIncome(financeInfoDbModel: FinanceInfoDbModel)

    @Delete
    fun deleteIncome(financeInfoDbModel: FinanceInfoDbModel)
}