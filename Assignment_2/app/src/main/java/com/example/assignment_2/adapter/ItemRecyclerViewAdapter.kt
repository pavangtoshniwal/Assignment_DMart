package com.example.assignment_2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_2.R
import com.example.assignment_2.constant.VIEW_TYPE_BANNER
import com.example.assignment_2.constant.VIEW_TYPE_GRID
import com.example.assignment_2.constant.VIEW_TYPE_LIST
import com.example.assignment_2.model.Product
import com.example.assignment_2.viewholder.ViewHolderFactory

class ItemRecyclerViewAdapter(private val context: Context, private var list: ArrayList<Product>) : AppRecyclerViewAdapter<Product>(list,context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getViewHolder(LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
            , viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<Product>).bind(mListItems[position], context)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position, mListItems[position])
    }

    override fun getLayoutId(position: Int, product: Product): Int {
        return when(product.viewType){
            VIEW_TYPE_LIST -> R.layout.list_item_view
            VIEW_TYPE_GRID -> R.layout.grid_item_view
            VIEW_TYPE_BANNER -> R.layout.banner_item_view
            else -> R.layout.list_item_view
        }
    }

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderFactory.create(view,viewType)
    }
}