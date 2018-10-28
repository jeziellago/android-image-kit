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

package com.jeziellago.android.imagekit.draw

import android.graphics.*
import com.jeziellago.android.imagekit.config.DEFAULT_EMPTY_STROKE
import com.jeziellago.android.imagekit.config.DEFAULT_STROKE_WIDTH
import com.jeziellago.android.imagekit.config.DEFAULT_TEXT_SIZE

class ImagePaint(private var image: Bitmap) {

    private var canvas: Canvas
    private var paint = Paint()

    init {
        image = image.copy(image.config, true)
        canvas = Canvas(image)
    }

    fun drawText(text: String,
                 textSize: Float = DEFAULT_TEXT_SIZE,
                 textColor: Int = Color.BLACK,
                 positionX: Float,
                 positionY: Float): ImagePaint {
        clearPaint()
        paint.style = Paint.Style.FILL
        paint.textSize = textSize
        paint.color = textColor
        canvas.drawText(text, positionX, positionY, paint)
        return this
    }

    fun drawRect(rect: Rect,
                 color: Int = Color.RED,
                 paintStyle: Paint.Style = Paint.Style.STROKE,
                 strokeWidth: Float = DEFAULT_STROKE_WIDTH): ImagePaint {
        changePaint(color, paintStyle, strokeWidth)
        canvas.drawRect(rect, paint)
        return this
    }

    fun drawCircle(width: Float,
                   height: Float,
                   radius: Float,
                   color: Int = Color.RED,
                   paintStyle: Paint.Style = Paint.Style.STROKE,
                   strokeWidth: Float = DEFAULT_STROKE_WIDTH): ImagePaint {
        changePaint(color, paintStyle, strokeWidth)
        canvas.drawCircle(width, height, radius, paint)
        return this
    }

    fun drawPoints(vararg points: Float,
                   color: Int = Color.RED,
                   paintStyle: Paint.Style = Paint.Style.FILL,
                   strokeWidth: Float = DEFAULT_EMPTY_STROKE): ImagePaint {
        changePaint(color, paintStyle, strokeWidth)
        canvas.drawPoints(points, paint)
        return this
    }

    fun setCustomPaint(customPaint: Paint): ImagePaint {
        paint = customPaint
        return this
    }

    fun toBitmap() = image

    private fun clearPaint() { paint = Paint() }

    private fun changePaint(color: Int,
                            paintStyle: Paint.Style,
                            strokeWidth: Float) {
        clearPaint()
        paint.color = color
        paint.style = paintStyle
        paint.strokeWidth = strokeWidth
    }

}