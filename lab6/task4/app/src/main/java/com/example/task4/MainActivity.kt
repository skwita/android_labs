package com.example.task4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bn: Button = findViewById(R.id.bn)
        val img: ImageView = findViewById(R.id.imageView)
        bn.setOnClickListener {
            Glide.with(this)
                 .load("https://i.simpalsmedia.com/play.md/thumbs/854x480/0D981EAD-B03A-6EA3-BBDA-87ACB8B51C85.jpg")
                 .into(img)
        }
    }
}