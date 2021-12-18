package com.example.executorserviceapp


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future

class MainActivity : AppCompatActivity() {
    var secondsElapsed: Int = 0
    private var startTime: Long = 0
    private var endTime: Long = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var sharedPref: SharedPreferences

    private lateinit var bgTask: Future<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
        sharedPref = getSharedPreferences("Seconds elapsed", Context.MODE_PRIVATE)
        textSecondsElapsed.text = getString(R.string.text_view, sharedPref.getInt("Seconds elapsed", secondsElapsed))

    }

    private fun startBgTask(executorService: ExecutorService) = executorService.submit {
        while (true) {
            Thread.sleep(1000)
            Log.i("thread","${Thread.currentThread()}  is running")
            textSecondsElapsed.post {
                textSecondsElapsed.text = getString(R.string.text_view, secondsElapsed + ((System.currentTimeMillis() - startTime)/1000))
            }
        }
    }

    override fun onStart() {
        startTime = System.currentTimeMillis()

        Log.i("thread","${Thread.currentThread()}  start")

        secondsElapsed = sharedPref.getInt("Seconds elapsed", secondsElapsed)
        bgTask = startBgTask(MyApplication.executorService)

        super.onStart()
    }


    override fun onStop() {
        bgTask.cancel(true)

        Log.i("thread","${Thread.currentThread()}  stop")

        endTime = System.currentTimeMillis()
        secondsElapsed += ((endTime - startTime)/1000).toInt()
        with(sharedPref.edit()) {
            putInt("Seconds elapsed", secondsElapsed)
            apply()
        }
        super.onStop()
    }

}
