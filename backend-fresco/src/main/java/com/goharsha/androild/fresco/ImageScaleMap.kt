package com.goharsha.androild.fresco

import android.widget.ImageView
import com.facebook.drawee.drawable.ScalingUtils

val ImageScaleMap = mapOf(
    ImageView.ScaleType.CENTER to ScalingUtils.ScaleType.CENTER,
    ImageView.ScaleType.CENTER_CROP to ScalingUtils.ScaleType.CENTER_CROP,
    ImageView.ScaleType.CENTER_INSIDE to ScalingUtils.ScaleType.CENTER_INSIDE,
    ImageView.ScaleType.FIT_CENTER to ScalingUtils.ScaleType.FIT_CENTER,
    ImageView.ScaleType.FIT_START to ScalingUtils.ScaleType.FIT_START,
    ImageView.ScaleType.FIT_END to ScalingUtils.ScaleType.FIT_END,
    ImageView.ScaleType.FIT_XY to ScalingUtils.ScaleType.FIT_XY,
    ImageView.ScaleType.MATRIX to ScalingUtils.ScaleType.FOCUS_CROP
)