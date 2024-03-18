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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countdowntimertest.state.animateFloatAsState
import com.example.countdowntimertest.ui.theme.Screen_BG
import com.example.countdowntimertest.ui.theme.Title_Color
import com.example.countdowntimertest.utils.getTimeParts
import kotlin.math.ceil

@Composable
fun CountDownScreen(seconds: Int,
                    endMillis: Long,) {
    val animatedSeconds by animateFloatAsState(key = endMillis, targetValue = seconds.toFloat())

    val currentSeconds = ceil(animatedSeconds).toInt()
    val nextSeconds = currentSeconds - 1
    val factor = currentSeconds.toFloat() - animatedSeconds
    val currentParts = getTimeParts(currentSeconds)
    val nextParts = getTimeParts(nextSeconds)

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
                FlipView(
                    currentText = currentParts.days.toString().padStart(2, '0'),
                    nextText = nextParts.days.toString().padStart(2, '0'),
                    factor = if (currentParts.days == nextParts.days) 0F else factor
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
                FlipView(
                    currentText = currentParts.hours.toString().padStart(2, '0'),
                    nextText = nextParts.hours.toString().padStart(2, '0'),
                    factor = if (currentParts.hours == nextParts.hours) 0F else factor
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
                FlipView(
                    currentText = currentParts.minutes.toString().padStart(2, '0'),
                    nextText = nextParts.minutes.toString().padStart(2, '0'),
                    factor = if (currentParts.minutes == nextParts.minutes) 0F else factor
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
                FlipView(
                    currentText = currentParts.seconds.toString().padStart(2, '0'),
                    nextText = nextParts.seconds.toString().padStart(2, '0'),
                    factor = if (currentParts.seconds == nextParts.seconds) 0F else factor
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Seconds", fontSize = 16.sp, color = Title_Color)
            }
        }
    }
}