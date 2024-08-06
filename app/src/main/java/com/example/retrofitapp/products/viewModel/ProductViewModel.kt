package com.example.retrofitapp.products.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitapp.Models.Product
import com.example.retrofitapp.network.ApiClient
import com.example.retrofitapp.products.Repo.ProductsRepository
import kotlinx.coroutines.launch

class ProductViewModel(var productRepository : ProductsRepository) : ViewModel(){

    private val _listOfProducts = MutableLiveData<List<Product>>()
    val listOfProducts : LiveData<List<Product>>?= _listOfProducts

    fun getProducts(){
        viewModelScope.launch {
            val result = productRepository.getRemoteProducts()
            if(result.isSuccessful){
                _listOfProducts.value = result.body()?.products
                Log.i("RESULT", "After NotifyChange")
                Log.i("RESULT", result.body().toString())
            }else{
                Log.i("RESULT", result.message().toString())
                Log.i("RESULT", "errooooooooooooor")
            }
        }
    }
}