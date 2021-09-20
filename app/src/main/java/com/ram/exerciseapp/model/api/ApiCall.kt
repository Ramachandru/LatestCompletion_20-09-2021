package com.ram.exerciseapp.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCall {
    companion object {
        fun getrofit() = Retrofit.Builder().baseUrl(ApiInterface.BASEURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}