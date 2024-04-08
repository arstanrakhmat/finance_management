package com.example.myfinance.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "finance_tbl")
data class FinanceInfoDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val amount: Int,
    val dt: Int,
    val comment: String,
    val isIncome: Boolean,
    val type: Type
)

enum class Type(displayName: String) {
    OTHER("Другое"),
    SALARY("Заработная плата"),
    BUSINESS_INCOME("Доход от бизнеса"),
    DEBT_CREDIT("Кредит/Долг"),
    DEPOSIT("Депозит"),
    STIPEND("Стипендия"),
    SAVING("Сбережения"),
    MEDICINE("Медицина"),
    TRANSPORT("Транспорт"),
    PUBLIC_UTILITIES("Комунальные услуги"),
    BORROW_MOONEY("Деньги взаймы"),
    FOOD("Еда")
}