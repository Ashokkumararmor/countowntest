package com.example.countdowntimertest.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countdowntimertest.ui.theme.Count_Down_Color
import com.example.countdowntimertest.ui.theme.Screen_BG
import com.example.countdowntimertest.ui.theme.Title_Color

@Composable
fun CountDownScreen(countDown: Long) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Screen_BG),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "WE'RE LAUNCHING SOON",
            fontSize = 30.sp,
            color = Title_Color,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.width(50.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .background(Screen_BG),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "8",
                    fontSize = 24.sp,
                    color = Count_Down_Color
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Days", fontSize = 16.sp, color = Title_Color)
            }

            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .background(Screen_BG),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "23",
                    fontSize = 24.sp,
                    color = Count_Down_Color
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Hours", fontSize = 16.sp, color = Title_Color)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .background(Screen_BG),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "59",
                    fontSize = 24.sp,
                    color = Count_Down_Color
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Minutes", fontSize = 16.sp, color = Title_Color)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .background(Screen_BG),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "59",
                    fontSize = 24.sp,
                    color = Count_Down_Color
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Seconds", fontSize = 16.sp, color = Title_Color)
            }
        }
    }
}