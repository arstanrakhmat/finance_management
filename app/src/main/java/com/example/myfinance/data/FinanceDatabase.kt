package com.example.myfinance.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfinance.model.FinanceInfo

@Database(entities = [FinanceInfo::class], version = 1, exportSchema = false)
abstract class FinanceDatabase : RoomDatabase() {
    abstract fun financeDao(): FinanceDao
}