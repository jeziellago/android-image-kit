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


fun IntArray.convertToGrayScale() {
    for (index in 0 until size) {
        val px = this[index]
        this[index] = px.pixelToGray()
    }
}

private fun Int.pixelToGray(): Int {
    val grayPx = convertToRedRGB() +
            convertToBlueRGB() +
            convertToGreenRGB()
    return ((grayPx / RGB_ARRAY_SIZE) shl 24)
}