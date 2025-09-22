package com.orghaniian.clock

import java.time.LocalDateTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

enum class ClockFormat {
    HoursMinutes, HoursMinutesSeconds
}

fun LocalDateTime.format(format: ClockFormat) = when (format) {
    ClockFormat.HoursMinutes -> "%02d:%02d".format(hour, minute)
    ClockFormat.HoursMinutesSeconds -> "%02d:%02d:%02d".format(hour, minute, second)
}

fun ClockFormat.now(): String = LocalDateTime.now().format(this)

val ClockFormat.refreshDelay: Duration
    get() = when (this) {
        ClockFormat.HoursMinutes -> 1.minutes
        ClockFormat.HoursMinutesSeconds -> 1.seconds
    }
