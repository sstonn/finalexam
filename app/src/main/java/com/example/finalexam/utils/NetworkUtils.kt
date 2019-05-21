package com.example.finalexam.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkUtils {
    companion object {
        fun hasInternetConnection(context: Context): Boolean = activeNetwork(context)?.isConnectedOrConnecting == true

        ///////////////////
        // Helper Functions
        // ////////////////
        private fun activeNetwork(context: Context): NetworkInfo? = connectivityManager(context).activeNetworkInfo

        private fun connectivityManager(context: Context): ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}