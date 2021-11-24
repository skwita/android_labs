package com.example.task2
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivityViewModel: ViewModel() {
    val bitmap: MutableLiveData<Bitmap> = MutableLiveData()

    fun downloadDogImage() {
        viewModelScope.launch(Dispatchers.IO) {
            val newUrl =
                URL("https://i.simpalsmedia.com/play.md/thumbs/854x480/0D981EAD-B03A-6EA3-BBDA-87ACB8B51C85.jpg")
            val mIcon = BitmapFactory.decodeStream(newUrl.openConnection().getInputStream())
            bitmap.postValue(mIcon)
        }
    }
}