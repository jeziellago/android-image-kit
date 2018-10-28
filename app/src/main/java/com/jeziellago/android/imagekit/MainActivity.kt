package com.jeziellago.android.imagekit

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadImage()
    }

    private fun loadImage() {
        val imgStream = assets.open("android.jpg")
        val bmp = BitmapFactory.decodeStream(imgStream)
        val image = Image(bmp)
        img_show.setImageBitmap(image.convertToGray().getBitmap())
    }
}
