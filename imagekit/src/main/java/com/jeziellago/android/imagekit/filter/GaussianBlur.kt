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

package com.jeziellago.android.imagekit.filter

import android.content.Context
import android.graphics.Bitmap
import android.renderscript.Allocation
import android.renderscript.Allocation.MipmapControl.MIPMAP_NONE
import android.renderscript.Allocation.USAGE_GRAPHICS_TEXTURE
import android.renderscript.Allocation.createFromBitmap
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur


class GaussianBlur(context: Context) {

    private val renderScript = RenderScript.create(context)

    fun apply(sourceBitmap: Bitmap, radius: Float = 25f): Bitmap {
        val outputBitmap = Bitmap.createBitmap(
                sourceBitmap.width,
                sourceBitmap.height,
                sourceBitmap.config)

        return createIntrinsicBlur(
                outputBitmap = outputBitmap,
                radius = radius,
                inAlloc = createAllocation(sourceBitmap),
                outAlloc = createAllocation(outputBitmap, true))
    }

    private fun createAllocation(bitmap: Bitmap, output: Boolean = false): Allocation {
        return if (output)
            createFromBitmap(renderScript, bitmap)
        else
            createFromBitmap(renderScript, bitmap, MIPMAP_NONE, USAGE_GRAPHICS_TEXTURE)
    }

    private fun createIntrinsicBlur(outputBitmap: Bitmap,
                                    radius: Float,
                                    inAlloc: Allocation,
                                    outAlloc: Allocation): Bitmap {
        val script = ScriptIntrinsicBlur.create(renderScript, inAlloc.element)
        with(script) {
            setRadius(radius)
            setInput(inAlloc)
            forEach(outAlloc)
            outAlloc.copyTo(outputBitmap)
            renderScript.destroy()
        }
        return outputBitmap
    }
}