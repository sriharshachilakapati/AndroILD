package com.goharsha.androild.fresco

import com.goharsha.androild.core.ImageLoader
import com.goharsha.androild.core.ImageSource
import com.goharsha.androild.core.ImageTarget
import com.goharsha.androild.core.ImageViewTarget

val FrescoImageLoader = ImageLoader<ImageSource, ImageTarget> { source, target ->
    if (target !is ImageViewTarget) {
        throw UnsupportedOperationException("Fresco can only be used with ImageView targets")
    }

    FrescoImageViewManager.getFor(target.imageView)
        .setImageSource(source)
}