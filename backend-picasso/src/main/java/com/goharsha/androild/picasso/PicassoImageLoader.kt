package com.goharsha.androild.picasso

import com.goharsha.androild.core.*
import com.squareup.picasso.Picasso

val PicassoImageLoader = ImageLoader<ImageRequest, ImageTarget> { request, target ->
    val source = request.imageSource ?: throw IllegalStateException("ImageSource must be defined")

    var picasso = when (source) {
        is UrlImageSource -> Picasso.get().load(source.url)
        is DrawableImageSource -> Picasso.get().load(source.res)
    }

    if (request.width != ImageRequest.ORIGINAL_SIZE && request.height != ImageRequest.ORIGINAL_SIZE) {
        picasso = picasso.resize(request.width, request.height)
    }

    when (target) {
        is ImageViewTarget -> picasso.into(target.imageView)
    }
}