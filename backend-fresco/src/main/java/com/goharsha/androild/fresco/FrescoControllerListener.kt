package com.goharsha.androild.fresco

import android.graphics.drawable.Animatable
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.interfaces.DraweeHierarchy
import com.facebook.drawee.view.DraweeHolder
import com.facebook.imagepipeline.image.ImageInfo

class FrescoControllerListener(
    private val imageView: ImageView,
    private val draweeHolder: DraweeHolder<DraweeHierarchy>
) : BaseControllerListener<ImageInfo>() {

    override fun onFinalImageSet(id: String?, imageInfo: ImageInfo?, animatable: Animatable?) {
        updateImageDrawable(imageInfo)
    }

    override fun onIntermediateImageSet(id: String?, imageInfo: ImageInfo?) {
        updateImageDrawable(imageInfo)
    }

    private fun updateImageDrawable(imageInfo: ImageInfo?) {
        imageInfo?.let { resizeImageView(it) }
        imageView.setImageDrawable(draweeHolder.topLevelDrawable)
        invalidateImageView()
    }

    private fun resizeImageView(imageInfo: ImageInfo) {
        var viewWidth = imageView.layoutParams.width
        var viewHeight = imageView.layoutParams.height

        val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT
        val matchParent = ViewGroup.LayoutParams.MATCH_PARENT
        val aspectRatio = imageInfo.width / imageInfo.height.toFloat()

        if (viewWidth == wrapContent && viewHeight == wrapContent) {
            viewWidth = imageInfo.width
            viewHeight = imageInfo.height

            val widthExceedsParent = viewWidth > (imageView.parent as? View)?.width ?: viewWidth
            val heightExceedsParent = viewHeight > (imageView.parent as? View)?.height ?: viewHeight

            when {
                widthExceedsParent && heightExceedsParent ->
                    resizeImageView(matchParent, matchParent)

                widthExceedsParent -> resizeImageView(matchParent, viewHeight)
                heightExceedsParent -> resizeImageView(viewWidth, matchParent)
            }
        }

        if (viewWidth == wrapContent) {
            viewWidth = (viewHeight * aspectRatio).toInt()

            if (viewWidth > (imageView.parent as? View)?.width ?: viewWidth) {
                resizeImageView(matchParent, viewHeight)
            } else {
                resizeImageView(viewWidth, viewHeight)
            }
        }

        if (viewHeight == wrapContent) {
            viewHeight = (viewWidth / aspectRatio).toInt()

            if (viewHeight > (imageView.parent as? View)?.height ?: viewHeight) {
                resizeImageView(viewWidth, matchParent)
            } else {
                resizeImageView(viewWidth, viewHeight)
            }
        }
    }

    private fun resizeImageView(width: Int, height: Int) = with(imageView.layoutParams) {
        this.width = width
        this.height = height
    }

    private fun invalidateImageView() {
        imageView.invalidate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2 && !imageView.isInLayout) {
            imageView.requestLayout()
        }
    }
}