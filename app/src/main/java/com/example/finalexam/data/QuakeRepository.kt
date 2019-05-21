package com.example.finalexam.data

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.ANRequest

class QuakeRepository {
    companion object {
        fun getQuakes(url: String): ANRequest<out ANRequest<*>>? = AndroidNetworking.get(url).build()
    }
}