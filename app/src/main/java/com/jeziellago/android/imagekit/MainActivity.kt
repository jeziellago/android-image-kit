package com.jeziellago.android.imagekit

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jeziellago.android.imagekit.draw.ImagePaint
import com.jeziellago.android.imagekit.filter.GaussianBlur
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
        val imageBmp = Image(bmp).toBitmap()

        val gb = GaussianBlur(this).apply(imageBmp)

        val bitmap = ImagePaint(gb)
                .drawText("Gaussian Blur", 50f, Color.WHITE, 50f, 200f)
                .toBitmap()

        img_show.setImageBitmap(bitmap)
    }
}
