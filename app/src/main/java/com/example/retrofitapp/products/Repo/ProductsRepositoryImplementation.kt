package com.example.retrofitapp.products.Repo

import androidx.lifecycle.LiveData
import com.example.mvp_task.db.LocalDataSource
import com.example.retrofitapp.Models.Product
import com.example.retrofitapp.Models.ProductResponse
import com.example.retrofitapp.network.RemoteDataSource
import retrofit2.Response

class ProductsRepositoryImplementation(var remoteDataSource: RemoteDataSource , var localDataSource: LocalDataSource) : ProductsRepository{
    override suspend fun getRemoteProducts(): Response<ProductResponse> {
             return remoteDataSource.getProductResponse()
    }

    override suspend fun getLocalProducts(): LiveData<List<Product>> {
        return localDataSource.getAllQuotes()
    }

    override suspend fun insertProducts(product: Product) {
        localDataSource.insertQuote(product)
    }
}