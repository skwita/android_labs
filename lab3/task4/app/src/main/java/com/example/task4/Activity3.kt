package com.example.task4

import android.content.Intent
import android.content.Intent.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.task4.databinding.Activity3Binding

class Activity3 : AppCompatActivity() {

    private lateinit var binding: Activity3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity3Binding.inflate(layoutInflater)
        binding.buttonToFirst.setOnClickListener { onButtonToFirstClicked() }
        binding.buttonToSecond.setOnClickListener { onButtonToSecondClicked() }
        binding.bottomNav.setOnNavigationItemSelectedListener { onNavAboutClicked(it) }
        setContentView(binding.root)
    }

    private fun onButtonToFirstClicked() {
        startActivity(Intent(this, Activity1::class.java).setFlags(FLAG_ACTIVITY_REORDER_TO_FRONT))
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
