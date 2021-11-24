package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainActivityViewModel()
        val bn: Button = findViewById(R.id.bn)
        val img: ImageView = findViewById(R.id.imageView)

        bn.setOnClickListener {
            viewModel.downloadDogImage()
        }
        viewModel.bitmap.observe(this) {
            img.setImageBitmap(it)
        }
    }
}