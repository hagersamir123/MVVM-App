package com.example.retrofitapp.products.Repo

import androidx.lifecycle.LiveData
import com.example.retrofitapp.Models.Product
import com.example.retrofitapp.Models.ProductResponse
import retrofit2.Response

interface ProductsRepository {
    suspend fun getRemoteProducts() : Response<ProductResponse>
    suspend fun getLocalProducts() : LiveData<List<Product>>
    suspend fun insertProducts(product: Product)
}