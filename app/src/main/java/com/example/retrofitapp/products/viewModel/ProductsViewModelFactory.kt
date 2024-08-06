package com.example.retrofitapp.products.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitapp.products.Repo.ProductsRepository

class ProductsViewModelFactory(var productRepository : ProductsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(productRepository) as T
    }
}