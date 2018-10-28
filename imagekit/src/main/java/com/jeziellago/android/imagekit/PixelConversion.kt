package com.jeziellago.android.imagekit

const val RGB_ARRAY_SIZE = 3
const val RGB_R_INDEX = 0
const val RGB_G_INDEX = 1
const val RGB_B_INDEX = 2
const val EXP_4D_DIM_SIZE = 1

internal fun Int.convertToRedRGB(): Int {
    return this shr 16 and 0xFF
}

internal fun Int.convertToGreenRGB(): Int {
    return this shr 8 and 0xFF
}

internal fun Int.convertToBlueRGB(): Int {
    return this and 0xFF
}

fun Int.toRGBArray(): IntArray {
    return IntRGBArray(
            r = convertToRedRGB(),
            g = convertToGreenRGB(),
            b = convertToBlueRGB()
    ).toIntArray()
}

fun Int.toFloatArrayRGB(): FloatArray {
    return FloatRGBArray(
            r = convertToRedRGB(),
            g = convertToGreenRGB(),
            b = convertToBlueRGB()
    ).toFloatArray()
}

fun Int.toNormalizedArrayRGB(): FloatArray {
    return FloatRGBArray(
            r = convertToRedRGB(),
            g = convertToGreenRGB(),
            b = convertToBlueRGB()
    ).toNormalizedFloatArray()
}