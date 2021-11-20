package com.goharsha.androild.core

import androidx.annotation.DrawableRes

sealed class ImageSource

data class UrlImageSource(val url: String) : ImageSource()
data class DrawableImageSource(@DrawableRes val res: Int) : ImageSource()
