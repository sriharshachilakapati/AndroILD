package com.goharsha.androild.fresco

import com.goharsha.androild.core.*

val FrescoImageLoader = ImageLoader<ImageRequest, ImageTarget> { request, target ->
    if (target !is ImageViewTarget) {
        throw UnsupportedOperationException("Fresco can only be used with ImageView targets")
    }

    FrescoImageViewManager.getFor(target.imageView)
        .setImageRequest(request)
}