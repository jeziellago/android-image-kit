package com.jeziellago.android.imagekit.sample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sample_main.*

internal class SampleMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_main)
        setupSampleActivities()
    }

    private fun setupSampleActivities() {
        btn_convert_to_gray.setOnClickListener {
            startSample(SampleGrayConversionActivity::class.java)
        }

        btn_gaussian_blur.setOnClickListener {
            startSample(SampleGaussianBlurActivity::class.java)
        }

        btn_draw_text.setOnClickListener {
            startSample(SampleDrawTextActivity::class.java)
        }
    }

    private fun <T: SampleBaseActivity> startSample(clazz: Class<T>) {
        val intent = Intent(this@SampleMainActivity, clazz)
        startActivity(intent)
    }
}