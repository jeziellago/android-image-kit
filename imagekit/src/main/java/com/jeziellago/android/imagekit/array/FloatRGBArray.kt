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

package com.jeziellago.android.imagekit.array

import com.jeziellago.android.imagekit.config.RGB_ARRAY_SIZE
import com.jeziellago.android.imagekit.config.RGB_B_INDEX
import com.jeziellago.android.imagekit.config.RGB_G_INDEX
import com.jeziellago.android.imagekit.config.RGB_R_INDEX


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