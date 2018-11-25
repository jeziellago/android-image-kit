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

package com.jeziellago.android.imagekit.sample

import android.graphics.Color
import android.os.Bundle
import com.jeziellago.android.imagekit.draw.ImagePaint
import kotlinx.android.synthetic.main.activity_sample.*

internal class SampleDrawTextActivity : SampleBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        drawText()
    }

    private fun drawText() {
        val bitmap = ImagePaint(sampleImage)
                .drawText(text = "Draw text here",
                        textSize = 50f,
                        textColor = Color.WHITE,
                        positionX = 50f,
                        positionY = 200f)
                .toBitmap()

        img_show.setImageBitmap(bitmap)
    }
}
