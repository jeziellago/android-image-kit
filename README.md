
# Android Image Kit [![Build Status](https://travis-ci.org/jeziellago/android-image-kit.svg?branch=master)](https://travis-ci.org/jeziellago/android-image-kit) [![](https://jitpack.io/v/jeziellago/android-image-kit.svg)](https://jitpack.io/#jeziellago/android-image-kit)
Open-source library for image processing in Android.

- Image color space conversion
- Gaussian Blur Filter
- Bitmap to RGB Matrix
- Draw Text, Rect, Circle, Points

### RGB to Gray Scale
```kotlin
val grayImage = Image(rgbImage)
                .convertToGray()
                .toBitmap()
```

### Bitmap to RGB Matrix
```kotlin
val rgb3dMatrix = Image(imageBitmap).convertToRGBMatrix()
```

### Resize
```kotlin
val resizedBitmap = Image(imageBitmap)
                .resize(newWidth = 200f, newHeight = 250f)
                .toBitmap()
```

### Reshape to 4D (used in machine learning)
```kotlin
val image4dArray = Image(imageBitmap).reshapeTo4D()
```

### Gaussian Blur Filter
```kotlin
val gaussianBlurImage = GaussianBlur(context).apply(sourceImage)
```

### Drawing Text
```kotlin
val bitmap = ImagePaint(sourceBitmap)
                .drawText(text = "Draw text here",
                        textSize = 50f,
                        textColor = Color.WHITE,
                        positionX = 50f,
                        positionY = 200f)
                .toBitmap()
```
### Drawing Points
```kotlin
val bitmap = ImagePaint(sampleImage)
                .drawPoints(points = 10f, 20f, 30f, ...)
                .toBitmap()
```

### Drawing Rect
```kotlin
val bitmap = ImagePaint(sampleImage)
                .drawRect(rect = rectObject)
                .toBitmap()
```

_This library is in working progress_. Contribute to new features!
