package com.example.retrofitapp.network

import com.example.retrofitapp.Models.ProductResponse
import retrofit2.Response
import retrofit2.create

object ApiClient : RemoteDataSource{
     override suspend fun getProductResponse(): Response<ProductResponse> {
        return RetrofitService.retrofit.create(APIService::class.java).getAllProducts()
    }
}