package com.jeziellago.android.imagekit

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PixelConversionTest {

    @Test
    fun `Assert pixel is converted to Red in RGB`() {
        val pixel = 65536
        val red = pixel.convertToRedRGB()
        assertEquals(red, 1)
    }

    @Test
    fun `Assert pixel is converted to Green in RGB`() {
        val pixel = 256
        val green = pixel.convertToGreenRGB()
        assertEquals(green, 1)
    }

    @Test
    fun `Assert pixel is converted to Blue in RGB`() {
        val pixel = 1
        val blue = pixel.convertToBlueRGB()
        assertEquals(blue, 1)
    }

    @Test
    fun `Assert pixel array is converted to RGB Matrix`() {
        val width = 200
        val height = 150
        val pixels = IntArray(width * height)
        val matrix = pixels.pixelArrayToRGBMatrix(width, height)

        val assertCondition = matrix.size == width &&
                matrix[0].size == height &&
                matrix[0][0].size == RGB_ARRAY_SIZE

        assertTrue(assertCondition)
    }
}