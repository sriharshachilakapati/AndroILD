package com.goharsha.androild.coil

import android.widget.ImageView
import coil.load
import com.goharsha.androild.core.*

val CoilImageLoader = ImageLoader<ImageSource, ImageTarget> { source, target ->
    when (target) {
        is ImageViewTarget -> loadIntoImageView(source, target.imageView)
    }
}

private fun loadIntoImageView(source: ImageSource, view: ImageView) = when (source) {
    is UrlImageSource -> view.load(source.url)
    is DrawableImageSource -> view.load(source.res)
}
