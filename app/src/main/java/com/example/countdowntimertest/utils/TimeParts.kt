package com.example.countdowntimertest.utils

fun getTimeParts(seconds: Int): TimeParts {
    val partDays = seconds / (24 * 3600)
    val partHours = (seconds % (24 * 3600)) / 3600
    val partMinutes = (seconds % 3600) / 60
    val partSeconds = seconds % 60

    return TimeParts(
        days = partDays,
        hours = partHours,
        minutes = partMinutes,
        seconds = partSeconds
    )
}

class TimeParts(
    val days: Int,
    val hours: Int,
    val minutes: Int,
    val seconds: Int
)