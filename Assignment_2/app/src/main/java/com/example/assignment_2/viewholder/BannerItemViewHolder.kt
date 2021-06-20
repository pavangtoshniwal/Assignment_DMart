package com.example.assignment_2.viewholder

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment_2.R
import com.example.assignment_2.adapter.AppRecyclerViewAdapter
import com.example.assignment_2.model.Product

class BannerItemViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView), AppRecyclerViewAdapter.Binder<Product> {
    var imageView: ImageView = itemView.findViewById(R.id.imageView)

    override fun bind(product: Product, context: Context) {
        Glide.with(context).load(product.imageUrl).into(imageView)
    }
}