package com.jeziellago.android.imagekit

import android.graphics.Bitmap
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test


class ImageTest {

    companion object {
        const val IMG_WIDTH = 250
        const val IMG_HEIGHT = 200
    }

    private lateinit var image: Image

    @Before
    fun setup() {
        val bmp = Bitmap.createBitmap(
                IMG_WIDTH,
                IMG_HEIGHT,
                Bitmap.Config.ARGB_4444,
                false)
        image = Image(bmp)
    }

    @Test
    fun withNewDimens_shouldRecreateResizedBitmap() {
        val expWidth = 100
        val expHeight = 100

        image.resize(expWidth.toFloat(), expHeight.toFloat())

        val bmp = image.getBitmap()
        val assertCondition = (bmp.width == expWidth && bmp.height == expHeight)
        assertTrue(assertCondition)
    }
}