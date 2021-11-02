package com.example.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var hasBeenPressed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.button1.setOnClickListener {
            if (!hasBeenPressed) {
                binding.button1.text = getString(R.string.button_text)
                hasBeenPressed = true
            }
        }
        setContentView(binding.root)
    }
}