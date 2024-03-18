package com.example.countdowntimertest.TimerViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TimerViewModel: ViewModel() {
    private val _countDownTimer = MutableStateFlow(777600L)
    val countDownTimer = _countDownTimer.asStateFlow()

    init {
        startTimer()
    }

    private fun startTimer() {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                _countDownTimer.value--
            }
        }
    }
}