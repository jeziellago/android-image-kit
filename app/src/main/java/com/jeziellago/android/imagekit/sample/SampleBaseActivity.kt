package com.jeziellago.android.imagekit.sample

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity

internal abstract class SampleBaseActivity : AppCompatActivity() {

    val sampleImage by lazy {
        val imgStream = assets.open(SAMPLE_IMAGE_NAME)
        BitmapFactory.decodeStream(imgStream)
    }

}