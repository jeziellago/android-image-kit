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

package com.jeziellago.android.imagekit.conversion

import com.jeziellago.android.imagekit.config.RGB_ARRAY_SIZE
import com.jeziellago.android.imagekit.array.FloatRGBArray
import com.jeziellago.android.imagekit.array.IntRGBArray


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