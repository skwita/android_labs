package com.example.task2
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivityViewModel: ViewModel() {
    val bitmap: MutableLiveData<Bitmap> = MutableLiveData()
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    fun downloadDogImage() {
        executorService.execute {
            Log.i("thread", "${Thread.currentThread()} Download")
            val newUrl =
                URL("https://i.simpalsmedia.com/play.md/thumbs/854x480/0D981EAD-B03A-6EA3-BBDA-87ACB8B51C85.jpg")
            val mIcon = BitmapFactory.decodeStream(newUrl.openConnection().getInputStream())
            bitmap.postValue(mIcon)
        }
    }

    override fun onCleared() {
        executorService.shutdown()
        super.onCleared()
    }
}