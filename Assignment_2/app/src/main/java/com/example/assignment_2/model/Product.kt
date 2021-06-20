package com.example.assignment_2.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("viewType")
    val viewType: Int,
    @SerializedName("img")
    val imageUrl: String
)