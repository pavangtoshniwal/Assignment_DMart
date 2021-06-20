package com.example.assignment_2.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_2.R
import com.example.assignment_2.constant.VIEW_TYPE_BANNER
import com.example.assignment_2.constant.VIEW_TYPE_GRID
import com.example.assignment_2.constant.VIEW_TYPE_LIST

object ViewHolderFactory {

    fun create(view: View, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.list_item_view -> ListItemViewHolder(view)
            R.layout.grid_item_view -> GridItemViewHolder(view)
            R.layout.banner_item_view -> BannerItemViewHolder(view)
            else -> {
                Log.d("ViewHolderFactory", "No View Holder found")
                ListItemViewHolder(view)
            }
        }
    }
}