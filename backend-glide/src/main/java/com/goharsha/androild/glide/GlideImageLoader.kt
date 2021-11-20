package com.goharsha.androild.glide

import com.bumptech.glide.Glide
import com.goharsha.androild.core.*

val GlideImageLoader = ImageLoader<ImageSource, ImageTarget> { source, target ->
    val context = when (target) {
        is ImageViewTarget -> target.imageView.context
    }

    val glide = when (source) {
        is UrlImageSource -> Glide.with(context).load(source.url)
        is DrawableImageSource -> Glide.with(context).load(source.res)
    }

    glide.into(target.imageView)
}