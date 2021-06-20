package com.example.assignment_2.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_2.R
import com.example.assignment_2.adapter.ItemRecyclerViewAdapter
import com.example.assignment_2.constant.SPAN_COUNT
import com.example.assignment_2.constant.VIEW_TYPE_BANNER
import com.example.assignment_2.constant.VIEW_TYPE_GRID
import com.example.assignment_2.constant.VIEW_TYPE_LIST
import com.example.assignment_2.model.ProductData
import com.example.assignment_2.util.getProductListFromSampleData
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rawProductData = getProductListFromSampleData(this, "sample_data.json")
        val productData = Gson().fromJson(rawProductData, ProductData::class.java)

        val adapter = ItemRecyclerViewAdapter(this, productData.productList)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val layoutManager = GridLayoutManager(this, SPAN_COUNT)
        val customSpanSizeLookup = object : SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)){
                    R.layout.list_item_view ->
                        SPAN_COUNT
                    R.layout.banner_item_view ->
                        SPAN_COUNT
                    R.layout.grid_item_view ->
                        1
                    else ->
                        SPAN_COUNT
                }
            }
        }
        layoutManager.spanSizeLookup = customSpanSizeLookup

        val mDividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            layoutManager.orientation
        )
        recyclerView.addItemDecoration(mDividerItemDecoration)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}
