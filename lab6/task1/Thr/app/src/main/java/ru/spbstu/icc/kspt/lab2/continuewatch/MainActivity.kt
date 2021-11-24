package ru.spbstu.icc.kspt.lab2.continuewatch

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var secondsElapsed: Int = 0
    private var startTime: Long = 0
    private var endTime: Long = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var sharedPref: SharedPreferences

    private lateinit var backgroundThread: Thread


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        sharedPref = getSharedPreferences("Seconds elapsed", Context.MODE_PRIVATE)
        textSecondsElapsed.text = getString(R.string.text_view,
            sharedPref.getInt("Seconds elapsed", secondsElapsed))

    }

    override fun onStart() {
        startTime = System.currentTimeMillis()
        secondsElapsed = sharedPref.getInt("Seconds elapsed", secondsElapsed)
        backgroundThread = Thread {
            while (!Thread.currentThread().isInterrupted) {
                try {
                    Thread.sleep(1000)
                    Log.i("thread","${Thread.currentThread()} is running")
                    textSecondsElapsed.post {
                        textSecondsElapsed.text = getString(R.string.text_view,
                            secondsElapsed + ((System.currentTimeMillis() - startTime)/1000))
                    }
                } catch (e: InterruptedException) {
                    Log.i("thread","${Thread.currentThread()} has stopped")
                    Thread.currentThread().interrupt()
                }
            }
        }
        backgroundThread.start()
        Log.i("thread","${Thread.currentThread()} start")
        super.onStart()
    }


    override fun onStop() {
        endTime = System.currentTimeMillis()
        backgroundThread.interrupt()
        Log.i("thread","${Thread.currentThread()} stop")
        secondsElapsed += ((endTime - startTime)/1000).toInt()
        with(sharedPref.edit()) {
            putInt("Seconds elapsed", secondsElapsed)
            apply()
        }
        super.onStop()
    }

}
