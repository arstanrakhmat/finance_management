package com.example.myfinance.screens.mainScreen.mooneyLeft

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfinance.R
import com.example.myfinance.model.FinanceInfo
import com.example.myfinance.model.Type

@Composable
fun MooneyLeftScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(), color = colorResource(id = R.color.less_white)
    ) {
        Column(
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 32.dp),
                text = "Текущий остаток",
                color = colorResource(id = R.color.gray),
                fontSize = 16.sp,
                fontWeight = FontWeight(500)
            )

            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                text = "110 000,89 c", color = colorResource(id = R.color.row_indicator),
                fontSize = 32.sp,
                fontWeight = FontWeight(700)
            )
        }
    }
}

@Composable
fun ShowMoneyLeft(list: List<FinanceInfo>) {
    Surface(color = Color.White) {
        LazyColumn {
            items(list) { detail ->
                OneFinanceItem(financeInfo = detail, onItemClick = { selected ->
                    //TODO: handle click event
                })
            }
        }
    }
}

@Composable
fun OneFinanceItem(
    financeInfo: FinanceInfo,
    onItemClick: (FinanceInfo) -> Unit = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(financeInfo) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(
                id = when (financeInfo.type) {
                    Type.SALARY -> R.drawable.ic_type_salary
                    Type.BUSINESS_INCOME -> R.drawable.ic_bussines_income
                    Type.DEBT_CREDIT -> R.drawable.ic_debt_credit
                    Type.DEPOSIT -> R.drawable.ic_deposit
                    Type.STIPEND -> R.drawable.ic_stipend
                    Type.SAVING -> R.drawable.ic_savings
                    Type.MEDICINE -> R.drawable.ic_medicine
                    Type.TRANSPORT -> R.drawable.ic_transport
                    Type.PUBLIC_UTILITIES -> R.drawable.ic_public_utilities
                    Type.BORROW_MOONEY -> R.drawable.ic_deposit
                    Type.FOOD -> R.drawable.ic_food
                    Type.OTHER -> R.drawable.ic_type_other
                }
            ), contentDescription = "Type"
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = when (financeInfo.type) {
                    Type.OTHER -> "Другое"
                    Type.SALARY -> "Заработная плата"
                    Type.BUSINESS_INCOME -> "Доход от бизнеса"
                    Type.DEBT_CREDIT -> "Кредит/Долг"
                    Type.DEPOSIT -> "Депозит"
                    Type.STIPEND -> "Стипендия"
                    Type.SAVING -> "Сбережения"
                    Type.MEDICINE -> "Медицина"
                    Type.TRANSPORT -> "Транспорт"
                    Type.PUBLIC_UTILITIES -> "Комунальные услуги"
                    Type.BORROW_MOONEY -> "Деньги взаймы"
                    Type.FOOD -> "Еда"
                },
                color = colorResource(id = R.color.gray),
                fontSize = 12.sp,
                fontWeight = FontWeight(400)
            )

            Text(
                text = if (financeInfo.isIncome) {
                    "${financeInfo.amount} c"
                } else "-${financeInfo.amount} c",
                color = if (financeInfo.isIncome) {
                    colorResource(id = R.color.row_indicator)
                } else Color.Red,
                fontSize = 18.sp,
                fontWeight = FontWeight(600)
            )
        }

        Text(
            text = financeInfo.dt.toString(),
            color = colorResource(id = R.color.gray),
            fontSize = 12.sp,
            fontWeight = FontWeight(400)
        )
    }
}