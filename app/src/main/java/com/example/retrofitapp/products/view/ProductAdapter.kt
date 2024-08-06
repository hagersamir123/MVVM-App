package com.example.retrofitapp.products.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitapp.Models.Product
import com.example.retrofitapp.R

class ProductAdapter ( val context: Context): RecyclerView.Adapter<ProductAdapter.MovieViewHolder>() {
    private var products : List<Product> = listOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view) }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.name.setText(products.get(position)?.title)
        Glide.with(context).load(products.get(position)?.thumbnail).into(holder.image)
    }

    override fun getItemCount() : Int{
        Log.i("RESULT","Size of List is : ${products.size?: -1}"  )
        return products.size?:0 }


    fun setProductList( products : List<Product>){
        this.products = products
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name : TextView
            get() = itemView.findViewById(R.id.txt_name)
        val image : ImageView
            get() = itemView.findViewById(R.id.img_movie)
        val layout: ConstraintLayout
            get() = itemView.findViewById(R.id.cv_item)
    }
}