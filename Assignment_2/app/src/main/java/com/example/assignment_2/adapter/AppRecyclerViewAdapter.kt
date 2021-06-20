package com.example.assignment_2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class AppRecyclerViewAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>{

    var mListItems: List<T>
    private lateinit var mContext: Context

    constructor(listItems: List<T>, context: Context) {
        this.mListItems = listItems
        this.mContext = context
    }

    constructor() {
        mListItems = emptyList()
    }

    fun setItems(listItems: List<T>) {
        this.mListItems = listItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
            , viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).bind(mListItems[position], mContext)
    }

    override fun getItemCount(): Int {
        return mListItems.size
    }

    protected abstract fun getLayoutId(position: Int, obj: T): Int

    abstract fun getViewHolder(view: View, viewType: Int):RecyclerView.ViewHolder

    /**
     * Interface that needs to be implemented by respective ViewHolder classes
     * to bind the view items for that respective viewHolder
     */
    internal interface Binder<T> {
        fun bind(data: T, context: Context)
    }
}