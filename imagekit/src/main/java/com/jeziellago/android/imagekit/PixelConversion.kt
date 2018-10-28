/*
 * Copyright (C) 2018 Android Image Kit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jeziellago.android.imagekit

import com.jeziellago.android.imagekit.array.FloatRGBArray
import com.jeziellago.android.imagekit.array.IntRGBArray

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

internal fun Int.convertToGray(): Int {
    val grayPx = convertToRedRGB() +
            convertToBlueRGB() +
            convertToGreenRGB()
    return ((grayPx / RGB_ARRAY_SIZE) shl 24)
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

fun IntArray.pixelArrayToRGBMatrix(width: Int, height: Int): Array<Array<FloatArray>> {
    val rgbMatrix = Array(width){ _ -> Array(height){ FloatArray(RGB_ARRAY_SIZE) }}
    var index = 0
    for (i in 0 until width) {
        for (j in 0 until height) {
            val px = this[index++]
            rgbMatrix[i][j] = px.toNormalizedArrayRGB()
        }
    }
    return rgbMatrix
}

fun IntArray.convertToGrayScale(width: Int, height: Int) {
    var index = 0
    for (i in 0 until width) {
        for (j in 0 until height) {
            val px = this[index]
            this[index++] = px.convertToGray()
        }
    }
}