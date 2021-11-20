package com.goharsha.androild.fresco

import android.net.Uri
import android.os.Build
import android.view.View
import android.widget.ImageView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.interfaces.DraweeHierarchy
import com.facebook.drawee.view.DraweeHolder
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.goharsha.androild.core.DrawableImageSource
import com.goharsha.androild.core.ImageSource
import com.goharsha.androild.core.UrlImageSource
import java.util.*

class FrescoImageViewManager(private val imageView: ImageView) : View.OnAttachStateChangeListener {
    companion object {
        @JvmStatic
        private val cache: MutableMap<ImageView, FrescoImageViewManager> = WeakHashMap()

        @JvmStatic
        fun getFor(target: ImageView) = cache.getOrElse(target) {
            val manager = FrescoImageViewManager(target)
            cache[target] = manager
            return@getOrElse manager
        }
    }

    private val draweeHolder: DraweeHolder<DraweeHierarchy>

    init {
        imageView.addOnAttachStateChangeListener(this)
        draweeHolder = DraweeHolder.create(null, imageView.context)
    }

    fun setImageSource(source: ImageSource) {
        val requestBuilder = when (source) {
            is DrawableImageSource -> ImageRequestBuilder.newBuilderWithResourceId(source.res)
            is UrlImageSource -> ImageRequestBuilder.newBuilderWithSource(Uri.parse(source.url))
        }

        val imageRequest = requestBuilder.build()
        val draweeHierarchy = GenericDraweeHierarchyBuilder(imageView.resources)
            .setActualImageScaleType(ImageScaleMap.getOrElse(imageView.scaleType) { ScalingUtils.ScaleType.FIT_CENTER })
            .build()

        draweeHolder.onDetach()
        draweeHolder.hierarchy = draweeHierarchy

        val controller = Fresco.newDraweeControllerBuilder().run {
            this.autoPlayAnimations = true
            this.imageRequest = imageRequest
            this.oldController = draweeHolder.controller

            build()
        }

        controller.addControllerListener(FrescoControllerListener(imageView, draweeHolder))
        draweeHolder.controller = controller

        if (isImageViewAttachedToWindow()) {
            draweeHolder.onAttach()
        }
    }

    private fun isImageViewAttachedToWindow(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            imageView.isAttachedToWindow
        } else {
            imageView.windowToken != null
        }
    }

    override fun onViewAttachedToWindow(v: View?) {
        draweeHolder.onAttach()
    }

    override fun onViewDetachedFromWindow(v: View?) {
        draweeHolder.onDetach()
    }
}