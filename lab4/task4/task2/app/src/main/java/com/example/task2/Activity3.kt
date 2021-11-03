package com.example.task2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.task2.databinding.Activity3Binding
import androidx.core.app.NavUtils




class Activity3 : AppCompatActivity() {

    private lateinit var binding: Activity3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity3Binding.inflate(layoutInflater)
        binding.bnToFirst.setOnClickListener { onButtonToFirstClicked() }
        binding.bnToSecond.setOnClickListener { onButtonToSecondClicked() }
        binding.navView.setOnItemSelectedListener { onNavAboutClicked(it) }
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun onButtonToFirstClicked() {
        this.setResult(RESULT_OK)
        finish()
    }

    private fun onButtonToSecondClicked() {
        finish()
    }

    private fun onNavAboutClicked(menuItem: MenuItem) : Boolean {
        when (menuItem.itemId) {
            R.id.to_about -> {
                startActivity(Intent(this, ActivityAbout::class.java))
            }
        }
        return false
    }
}
