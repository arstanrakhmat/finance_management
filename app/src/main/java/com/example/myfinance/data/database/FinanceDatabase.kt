package com.example.myfinance.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FinanceInfoDbModel::class], version = 1, exportSchema = false)
abstract class FinanceDatabase : RoomDatabase() {
    abstract fun financeDao(): FinanceDao
}