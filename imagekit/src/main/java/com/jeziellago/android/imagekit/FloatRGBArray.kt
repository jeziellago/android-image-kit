package com.jeziellago.android.imagekit


class FloatRGBArray(r: Int, g: Int, b: Int) {

    private var rgbArray: FloatArray = FloatArray(RGB_ARRAY_SIZE)

    init {
        rgbArray[RGB_R_INDEX] = r / 255.0f
        rgbArray[RGB_G_INDEX] = g / 255.0f
        rgbArray[RGB_B_INDEX] = b / 255.0f
    }

    fun toNormalizedFloatArray(): FloatArray {
        val normalizedArray = FloatArray(RGB_ARRAY_SIZE)
        normalizedArray[RGB_R_INDEX] = ((rgbArray[RGB_R_INDEX] - 0.5f) * 2)
        normalizedArray[RGB_G_INDEX] = ((rgbArray[RGB_G_INDEX] - 0.5f) * 2)
        normalizedArray[RGB_B_INDEX] = ((rgbArray[RGB_B_INDEX] - 0.5f) * 2)
        return normalizedArray
    }

    fun toFloatArray() = rgbArray

}