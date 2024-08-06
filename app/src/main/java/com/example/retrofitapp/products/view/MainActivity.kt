package com.example.retrofitapp.products.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.Models.Product
import com.example.retrofitapp.products.viewModel.ProductViewModel
import com.example.retrofitapp.R
import com.example.retrofitapp.network.ApiClient
import com.example.retrofitapp.network.RetrofitService
import com.example.retrofitapp.products.Repo.ProductsRepository
import com.example.retrofitapp.products.Repo.ProductsRepositoryImplementation
import com.example.retrofitapp.products.viewModel.ProductsViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: ProductAdapter
    lateinit var retrofitService: RetrofitService
    lateinit var productViewModel : ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_movies)

        myAdapter = ProductAdapter( this)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = layoutManager
        getViewModel()
        productViewModel.getProducts()
        productViewModel.listOfProducts?.observe(this , Observer {
            myAdapter.setProductList(it)
            Log.i("RESULT", it.toString())
            //Notify adapter with this data change
        })

    }

    private fun getViewModel(){
        val productsViewModelFactory = ProductsViewModelFactory(
            ProductsRepositoryImplementation(ApiClient)
        )
        productViewModel = ViewModelProvider(this , productsViewModelFactory).get(ProductViewModel::class.java)
    }
}