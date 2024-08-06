package com.example.mvp_task.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.retrofitapp.Models.Product

class LocalDataSource private constructor(context: Context) : LocalDataSourceInterface {
    private lateinit var quoteDao: QuoteDao
    init {
        val quotesDB = ProductesDB.getInstance(context.applicationContext)
        if (quotesDB != null){
            quoteDao = quotesDB.getProductDao()
        }
    }
    companion object {
        var instance: LocalDataSource? = null
        fun getInstance(context: Context): LocalDataSourceInterface {
            if (instance == null) {
                instance = LocalDataSource(context)
            }
            return instance as LocalDataSource
        }
    }

    override fun getAllQuotes(): LiveData<List<Product>> {
        return quoteDao.getAllProducts()
    }

    override suspend fun insertQuote(quote: Product) {
        quoteDao.insertProduct(quote);
    }

    override suspend fun deleteQuote(quote: Product) {
        quoteDao.deleteProduct(quote)
    }
}
