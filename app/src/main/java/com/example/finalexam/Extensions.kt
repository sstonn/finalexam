package com.example.finalexam

import android.preference.ListPreference

fun ListPreference.findEntryByValue(value: String): CharSequence? {
    val index = findIndexOfValue(value)
    return if (index >= 0) entries[index] else ""
}