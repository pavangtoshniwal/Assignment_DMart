package com.example.assignment_2.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment_2.R
import com.example.assignment_2.adapter.AppRecyclerViewAdapter
import com.example.assignment_2.model.Product

class ListItemViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView), AppRecyclerViewAdapter.Binder<Product> {
    var productName: TextView = itemView.findViewById(R.id.nameTV)
    var productImage: ImageView = itemView.findViewById(R.id.imageView)
    var price: TextView = itemView.findViewById(R.id.priceTV)
    var author: TextView = itemView.findViewById(R.id.authorTV)

    override fun bind(product: Product, context: Context) {
        productName.text = product.name
        Glide.with(context).load(product.imageUrl).into(productImage)
        price.text = context.getString(R.string.dollar_symbol).plus(product.price.toString())
        author.text = product.author
    }
}