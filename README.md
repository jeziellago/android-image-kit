
# Android Image Kit [![Build Status](https://travis-ci.org/jeziellago/android-image-kit.svg?branch=master)](https://travis-ci.org/jeziellago/android-image-kit) [![](https://jitpack.io/v/jeziellago/android-image-kit.svg)](https://jitpack.io/#jeziellago/android-image-kit)
Simple and clean image processing in Android.

- Image color space conversion
- Gaussian Blur Filter
- Bitmap to RGB Matrix
- Draw Text, Rect, Circle, Points

### Conversion to Gray Scale
```kotlin
val grayImage = Image(rgbImage)
                .convertToGray()
                .toBitmap()
```

### Gaussian Blur
```kotlin
val gaussianBlurImage = GaussianBlur(context).apply(sourceImage)
```

### Drawing text
```kotlin
val bitmap = ImagePaint(sourceBitmap)
                .drawText(text = "Draw text here",
                        textSize = 50f,
                        textColor = Color.WHITE,
                        positionX = 50f,
                        positionY = 200f)
                .toBitmap()
```
