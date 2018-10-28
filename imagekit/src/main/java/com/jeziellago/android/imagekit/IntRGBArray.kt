package com.jeziellago.android.imagekit


class IntRGBArray(r: Int, g: Int, b: Int) {

    private var rgbArray: IntArray = IntArray(RGB_ARRAY_SIZE)

    init {
        rgbArray[RGB_R_INDEX] = r
        rgbArray[RGB_G_INDEX] = g
        rgbArray[RGB_B_INDEX] = b
    }

    fun toIntArray() = rgbArray

}