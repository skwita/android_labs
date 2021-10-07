package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("test","on Create")
        setContentView(R.layout.activity_main)
    }

    override fun onPause(){
        super.onPause()
        Log.i("test","on Pause")
    }

    override fun onResume() {
        super.onResume()
        Log.i("test","on Resume")
    }

    override fun onStart() {
        super.onStart()
        Log.i("test","on Start")
    }

    override fun onStop() {
        super.onStop()
        Log.i("test","on Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("test","on Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("test","on Destroy")
    }
}