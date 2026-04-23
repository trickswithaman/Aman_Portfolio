package org.example.project.components

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

fun calculateExperience(
    startYear: Int,
    startMonth: Int
): String {
    val now = Clock.System.now()
    val dateTime = now.toLocalDateTime(TimeZone.currentSystemDefault())

    val currentYear = dateTime.year
    val currentMonth = dateTime.monthNumber

    val totalMonths = (currentYear - startYear) * 12 + (currentMonth - startMonth)

    val years = totalMonths / 12
    val months = totalMonths % 12

    return when {
        years > 0 && months > 0 -> "$years.${months}+ years"
        years > 0 -> "$years+ years"
        else -> "$months+ months"
    }
}