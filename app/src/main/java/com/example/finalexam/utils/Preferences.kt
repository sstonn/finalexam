package com.example.finalexam.utils

import android.content.Context
import android.preference.PreferenceManager

class Preferences(val context: Context) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getString(keyResId: Int, defaultResId: Int): String = preferences.getString(stringResource(keyResId), stringResource(defaultResId))

    private fun stringResource(resId: Int): String = context.getString(resId)
}