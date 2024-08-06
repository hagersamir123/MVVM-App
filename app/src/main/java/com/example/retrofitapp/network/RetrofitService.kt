package com.example.retrofitapp.network

import com.example.retrofitapp.Models.ProductResponse
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


object RetrofitService {
    val gson = GsonBuilder().serializeNulls().create()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}