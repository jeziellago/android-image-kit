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

    fun convertToRGBMatrix(matrixWidth: Int, matrixHeight: Int): Array<Array<FloatArray>> {
        val pixelValues = IntArray(matrixWidth * matrixHeight)

        with(image) { getPixels(pixelValues, EMPTY_OFFSET, width, EMPTY_X, EMPTY_X, width, height) }

        val finalMatrix = Array(matrixWidth){ _ -> Array(matrixHeight){FloatArray(RGB_ARRAY_SIZE)}}

        var index = 0
        for (i in 0 until matrixWidth) {
            for (j in 0 until matrixHeight) {
                val px = pixelValues[index++]
                finalMatrix[i][j] = px.toNormalizedArrayRGB()
            }
        }
        return finalMatrix
    }

    fun reshapeTo4D(matrix: Array<Array<FloatArray>>) =  Array(EXP_4D_DIM_SIZE){ matrix }

    fun getImageBitmap() = image
}