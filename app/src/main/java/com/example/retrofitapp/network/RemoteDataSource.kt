package com.example.retrofitapp.network

import com.example.retrofitapp.Models.ProductResponse
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getProductResponse(): Response<ProductResponse>
}