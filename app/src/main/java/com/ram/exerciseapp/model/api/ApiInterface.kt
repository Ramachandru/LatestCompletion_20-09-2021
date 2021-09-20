package com.ram.exerciseapp.model.api

import com.ram.exerciseapp.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    companion object {
        const val BASEURL: String = "https://jsonplaceholder.typicode.com/";
    }

    @GET("posts")
    fun getGroupOfUser(): Call<MutableList<User>>
}