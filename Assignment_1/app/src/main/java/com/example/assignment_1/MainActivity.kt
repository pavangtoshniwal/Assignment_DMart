package com.example.assignment_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        Glide.with(this).load("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg").into(imageView)
    }
}
