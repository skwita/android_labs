package com.example.task3

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.task3.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {

    private lateinit var binding: Activity3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity3Binding.inflate(layoutInflater)
        binding.bnToFirst.setOnClickListener { onButtonToFirstClicked() }
        binding.bnToSecond.setOnClickListener { onButtonToSecondClicked() }
        binding.navView.setOnNavigationItemSelectedListener { onNavAboutClicked(it) }
        setContentView(binding.root)
    }

    private fun onButtonToFirstClicked() {
        startActivity(Intent(this, MainActivity::class.java).setFlags(FLAG_ACTIVITY_CLEAR_TOP))
    }

    private fun onButtonToSecondClicked() {
        startActivity(Intent(this, Activity2::class.java).setFlags(FLAG_ACTIVITY_CLEAR_TOP))
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
