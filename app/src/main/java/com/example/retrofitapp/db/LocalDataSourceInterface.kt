package com.example.mvp_task.db

import androidx.lifecycle.LiveData
import com.example.retrofitapp.Models.Product

interface LocalDataSourceInterface{

    fun getAllQuotes(): LiveData<List<Product>>
    suspend fun insertQuote(quote: Product)
    suspend fun deleteQuote(quote: Product)
}