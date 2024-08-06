package com.example.mvp_task.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Insert
import com.example.retrofitapp.Models.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {
    @Query("SELECT * FROM Product")
    fun getAllProducts(): LiveData<List<Product>>

    @Insert
    suspend fun insertProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product : Product)
}