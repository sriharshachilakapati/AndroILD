package com.goharsha.androild.core

import android.widget.ImageView
import androidx.annotation.DrawableRes

class RequestBuilder(
    private val source: ImageSource? = null,
    private val imageLoader: ImageLoader<ImageSource, ImageTarget>? = null
) {
    fun load(url: String) = RequestBuilder(UrlImageSource(url), imageLoader)

    fun load(@DrawableRes drawableRes: Int) =
        RequestBuilder(DrawableImageSource(drawableRes), imageLoader)

    fun into(imageView: ImageView) {
        imageLoader ?: throw IllegalStateException("ImageLoader not defined")
        source ?: throw java.lang.IllegalStateException("Image Source not defined")

        imageLoader.loadInto(source, ImageViewTarget(imageView))
    }
}