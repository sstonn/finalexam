package com.example.finalexam

import android.os.Bundle
import android.preference.ListPreference
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceManager


class SettingsFragment : PreferenceFragment(), Preference.OnPreferenceChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.settings_main)
        bindPreferenceSummaryToValue(findPreference(R.string.settings_order_by_key))
        bindPreferenceSummaryToValue(findPreference(R.string.settings_min_magnitude_key))
        bindPreferenceSummaryToValue(findPreference(R.string.settings_limit_key))
    }

    fun findPreference(key: Int): Preference = findPreference(getString(key))

    private fun bindPreferenceSummaryToValue(preference: Preference) {
        preference.onPreferenceChangeListener = this

        val preferences = PreferenceManager.getDefaultSharedPreferences(preference.context)
        val preferenceString = preferences.getString(preference.key, "")
        onPreferenceChange(preference, preferenceString)
    }

    // //////////////////////////
    // OnPreferenceChangeListener
    // //////////////////////////
    override fun onPreferenceChange(preference: Preference?, value: Any?): Boolean {
        preference?.summary = when {
            preference is ListPreference -> preference.findEntryByValue(value.toString())
            else -> value.toString()
        }
        return true
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                SettingsFragment().apply {
                    arguments = Bundle()
                }
    }
}
