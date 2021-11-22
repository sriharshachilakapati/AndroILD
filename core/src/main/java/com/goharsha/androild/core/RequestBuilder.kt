package com.goharsha.androild.core

import android.widget.ImageView
import androidx.annotation.DrawableRes

class RequestBuilder(
    private val imageLoader: ImageLoader<ImageRequest, ImageTarget>,
    private val imageRequest: ImageRequest = ImageRequest()
) {
    fun load(url: String) =
        RequestBuilder(imageLoader, imageRequest.copy(imageSource = UrlImageSource(url)))

    fun load(@DrawableRes drawableRes: Int) = RequestBuilder(
        imageLoader,
        imageRequest.copy(imageSource = DrawableImageSource(drawableRes))
    )

    fun resize(width: Int, height: Int) = RequestBuilder(
        imageLoader,
        imageRequest.copy(width = width, height = height)
    )

    fun into(imageView: ImageView) {
        imageLoader.loadInto(imageRequest, ImageViewTarget(imageView))
    }
}