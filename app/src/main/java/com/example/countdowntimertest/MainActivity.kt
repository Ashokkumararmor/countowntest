package com.example.countdowntimertest

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.countdowntimertest.TimerViewModel.TimerViewModel
import com.example.countdowntimertest.presentation.CountDownScreen
import com.example.countdowntimertest.ui.theme.CountDownTimerTestTheme

class MainActivity : ComponentActivity() {

    private val timerViewModel: TimerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountDownTimerTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val countDown = timerViewModel.countDownTimer.collectAsState()
                    val endTime by remember { mutableLongStateOf(SystemClock.uptimeMillis()) }
                    CountDownScreen(seconds = countDown.value.toInt(),
                        endMillis = endTime)
                }
            }
        }
    }
}