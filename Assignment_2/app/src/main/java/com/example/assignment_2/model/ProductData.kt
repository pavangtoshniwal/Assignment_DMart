package com.example.assignment_2.model

import com.google.gson.annotations.SerializedName

data class ProductData (
    @SerializedName("products")
    val productList: ArrayList<Product>
)