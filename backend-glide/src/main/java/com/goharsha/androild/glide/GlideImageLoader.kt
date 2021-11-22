package com.goharsha.androild.glide

import com.bumptech.glide.Glide
import com.goharsha.androild.core.*

val GlideImageLoader = ImageLoader<ImageRequest, ImageTarget> { request, target ->
    val context = when (target) {
        is ImageViewTarget -> target.imageView.context
    }

    val source = request.imageSource ?: throw IllegalStateException("ImageSource must be defined")

    var glide = when (source) {
        is UrlImageSource -> Glide.with(context).load(source.url)
        is DrawableImageSource -> Glide.with(context).load(source.res)
    }

    if (request.width != ImageRequest.ORIGINAL_SIZE && request.height != ImageRequest.ORIGINAL_SIZE) {
        glide = glide.override(request.width, request.height)
    }

    glide.into(target.imageView)
}