package com.example.finalexam.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        const val FORMAT_DATE_MMMDDYYY = "MMM d, yyyy"
        const val FORMAT_DATE_HMA = "h:m a"

        fun format(date: Date, format: String) = SimpleDateFormat(format, Locale.US).format(date)
    }
}