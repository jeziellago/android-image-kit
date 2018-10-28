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

import android.graphics.Bitmap
import android.graphics.Matrix

class Image(private var image: Bitmap) {
    
    companion object {
        private const val EMPTY_X = 0
        private const val EMPTY_Y = 0
        private const val EMPTY_OFFSET = 0
        private const val NO_FILTER = false
    }

    fun resize(newWidth: Float, newHeight: Float): Image {
        val width = image.width
        val height = image.height
        val scaleWidth = newWidth / width
        val scaleHeight = newHeight / height
        
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)

        image = Bitmap.createBitmap(image, EMPTY_X, EMPTY_Y, width, height, matrix, NO_FILTER)
        return this
    }

    fun convertToGray(): Image {
        with(image) {
            val pixelValues = IntArray(width * height)
            getPixels(pixelValues, EMPTY_OFFSET, width, EMPTY_X, EMPTY_X, width, height)
            pixelValues.convertToGrayScale(width, height)
            image = Bitmap.createBitmap(pixelValues, width, height, image.config)
        }
        return this
    }

    fun convertToRGBMatrix(): Array<Array<FloatArray>> {
        with(image) {
            val pixelValues = IntArray(width * height)
            getPixels(pixelValues, EMPTY_OFFSET, width, EMPTY_X, EMPTY_X, width, height)
            return pixelValues.pixelArrayToRGBMatrix(width, height)
        }
    }

    fun reshapeTo4D() =  Array(EXP_4D_DIM_SIZE){ convertToRGBMatrix() }

    fun getBitmap() = image
}