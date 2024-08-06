package com.example.mvp_task.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitapp.Models.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductesDB: RoomDatabase() {
    abstract fun getProductDao(): QuoteDao
    companion object{
        private var instance:ProductesDB? = null
        @Synchronized
        fun getInstance(context: Context): ProductesDB? {
            synchronized(this) {
                if (instance == null)
                    instance = Room.databaseBuilder(
                        context.applicationContext, ProductesDB::class.java, "QuotesDataBase"
                    ).build()
            }
            return instance
        }
    }

}
