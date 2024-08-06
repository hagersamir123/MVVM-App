package com.example.retrofitapp.network

import com.example.retrofitapp.Models.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("products")
    suspend fun getAllProducts(): Response<ProductResponse>

}