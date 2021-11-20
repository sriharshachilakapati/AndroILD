package com.goharsha.androild.picasso

import com.goharsha.androild.core.*
import com.squareup.picasso.Picasso

val PicassoImageLoader = ImageLoader<ImageSource, ImageTarget> { source, target ->
    val picasso = when (source) {
        is UrlImageSource -> Picasso.get().load(source.url)
        is DrawableImageSource -> Picasso.get().load(source.res)
    }

    when (target) {
        is ImageViewTarget -> picasso.into(target.imageView)
    }
}