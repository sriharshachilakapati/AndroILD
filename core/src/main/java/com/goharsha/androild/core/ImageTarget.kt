package com.goharsha.androild.core

import android.widget.ImageView

sealed class ImageTarget

class ImageViewTarget(val imageView: ImageView) : ImageTarget()
