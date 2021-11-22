package com.goharsha.androild.coil

import android.widget.ImageView
import coil.imageLoader
import coil.load
import com.goharsha.androild.core.*

import coil.request.ImageRequest.Builder as CoilImageRequestBuilder

val CoilImageLoader = ImageLoader<ImageRequest, ImageTarget> { request, target ->
    when (target) {
        is ImageViewTarget -> loadIntoImageView(request, target.imageView)
    }
}

private fun loadIntoImageView(request: ImageRequest, view: ImageView) {
    val imageLoader = view.context.imageLoader
    val builder = createBuilder(request)

    when (request.imageSource) {
        is UrlImageSource ->
            view.load((request.imageSource as UrlImageSource).url, imageLoader, builder)

        is DrawableImageSource ->
            view.load((request.imageSource as DrawableImageSource).res, imageLoader, builder)

        else -> throw IllegalStateException("ImageSource must be defined")
    }
}

private fun createBuilder(request: ImageRequest): CoilImageRequestBuilder.() -> Unit = {
    if (request.width != ImageRequest.ORIGINAL_SIZE && request.height != ImageRequest.ORIGINAL_SIZE) {
        size(request.width, request.height)
    }
}