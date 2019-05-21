package com.example.finalexam.models

import com.example.finalexam.R
import com.example.finalexam.utils.DateUtils
import com.example.finalexam.utils.NumberUtils
import java.util.*

data class QuakeModel(private val place: String, val magnitude: Double, val time: Date, val url: String) {
    lateinit var placeOf: String
    lateinit var placeMain: String
    private val PLACE_SEPERATOR = " of "

    init {
        formatPlace()
    }

    private fun formatPlace() {
        if (place.indexOf(PLACE_SEPERATOR) != -1) {
            val values = place.split(PLACE_SEPERATOR)
            placeOf = (values[0] + PLACE_SEPERATOR).toUpperCase()
            placeMain = values[1]
        } else {
            placeOf = "Near the"
            placeMain = place
        }
    }

    fun displayMagnitide() = NumberUtils.format(magnitude, "0.0")
    fun displayDate() = DateUtils.format(time, DateUtils.FORMAT_DATE_MMMDDYYY)
    fun displayTime() = DateUtils.format(time, DateUtils.FORMAT_DATE_HMA)
    fun magnitudeColor(): Int {
        return when (Math.floor(magnitude).toInt()) {
            in 0..1 -> R.color.magnitude1
            2 -> R.color.magnitude2
            3 -> R.color.magnitude3
            4 -> R.color.magnitude4
            5 -> R.color.magnitude5
            6 -> R.color.magnitude6
            7 -> R.color.magnitude7
            8 -> R.color.magnitude8
            9 -> R.color.magnitude9
            else -> R.color.magnitude10plus
        }
    }
}
