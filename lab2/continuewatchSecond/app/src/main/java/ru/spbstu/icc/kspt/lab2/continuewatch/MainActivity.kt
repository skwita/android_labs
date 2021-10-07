package ru.spbstu.icc.kspt.lab2.continuewatch

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var secondsElapsed: Int = 0
    lateinit var textSecondsElapsed: TextView
    var isSeen = true
    private lateinit var sharedPref: SharedPreferences

    var backgroundThread = Thread {
        while (true) {
            if (isSeen) {
                Thread.sleep(1000)
                textSecondsElapsed.post {
                    textSecondsElapsed.text = getString(R.string.text_view, secondsElapsed++)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        sharedPref = getSharedPreferences(SECONDSELAPSED, Context.MODE_PRIVATE)
        backgroundThread.start()
    }

    override fun onStart() {
        isSeen = true
        secondsElapsed = sharedPref.getInt(SECONDSELAPSED, secondsElapsed)
        super.onStart()
    }

    override fun onStop() {
        isSeen = false
        with(sharedPref.edit()) {
            putInt(SECONDSELAPSED, secondsElapsed)
            apply()
        }
        super.onStop()
    }

    companion object { const val SECONDSELAPSED = "Seconds elapsed" }
}
