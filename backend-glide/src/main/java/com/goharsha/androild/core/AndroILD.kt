package com.goharsha.androild.core

import android.content.Context
import androidx.annotation.Keep
import com.goharsha.androild.glide.GlideImageLoader

@Keep
object AndroILD : AndroILDInterface<RequestBuilder> {
    override fun initialize(context: Context) {
    }

    override fun newRequest(): RequestBuilder = RequestBuilder(null, GlideImageLoader)
}