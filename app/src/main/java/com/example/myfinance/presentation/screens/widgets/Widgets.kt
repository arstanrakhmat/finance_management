package com.example.myfinance.presentation.screens.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfinance.R

@Preview
@Composable
fun TopAppBar(
    onBackPressedButton: () -> Unit = {}
) {
    Surface(modifier = Modifier.padding(start = 16.dp, end = 10.dp), color = Color.White) {
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.clickable {
                    onBackPressedButton
                },
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back Icon",

                )

            Text(
                text = "Детали", color = colorResource(id = R.color.black),
                fontSize = 18.sp,
                fontWeight = FontWeight(500)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = "Delete Icon"
            )
        }
    }
}