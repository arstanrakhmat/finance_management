package com.example.myfinance.data.mapper

import com.example.myfinance.data.database.FinanceInfoDbModel
import com.example.myfinance.domain.FinanceInfo

class FinanceMapper {
    fun mapDbModelToEntity(dbModel: FinanceInfoDbModel): FinanceInfo {
        return FinanceInfo(
            id = dbModel.id,
            amount = dbModel.amount,
            dt = dbModel.dt,
            comment = dbModel.comment,
            isIncome = dbModel.isIncome,
            type = dbModel.type
        )
    }
}