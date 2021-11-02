package com.example.task2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.task2.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {

    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        binding.bnToFirst.setOnClickListener { onButtonToFirstClicked() }
        binding.bnToThird.setOnClickListener { onButtonToThirdClicked() }
        binding.navView.setOnNavigationItemSelectedListener { onNavAboutClicked(it) }
        setContentView(binding.root)
    }

    private fun onButtonToFirstClicked(){
        finish()
    }

    private fun onButtonToThirdClicked(){
        startActivityForResult(Intent(this, Activity3::class.java), FROM_THIRD)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == FROM_THIRD && resultCode == Activity.RESULT_OK) {
            finish()
        }
    }

    private fun onNavAboutClicked(menuItem: MenuItem) : Boolean {
        when (menuItem.itemId) {
            R.id.to_about -> {
                startActivity(Intent(this, ActivityAbout::class.java))
            }
        }
        return false
    }

    companion object {
        const val FROM_THIRD = 0
    }
}