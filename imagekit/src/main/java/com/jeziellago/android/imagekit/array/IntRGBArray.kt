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

import com.jeziellago.android.imagekit.RGB_ARRAY_SIZE
import com.jeziellago.android.imagekit.RGB_B_INDEX
import com.jeziellago.android.imagekit.RGB_G_INDEX
import com.jeziellago.android.imagekit.RGB_R_INDEX


class IntRGBArray(r: Int, g: Int, b: Int) {

    private var rgbArray: IntArray = IntArray(RGB_ARRAY_SIZE)

    init {
        rgbArray[RGB_R_INDEX] = r
        rgbArray[RGB_G_INDEX] = g
        rgbArray[RGB_B_INDEX] = b
    }

    fun toIntArray() = rgbArray

}