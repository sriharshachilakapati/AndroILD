package com.goharsha.androild.core

import android.content.Context
import androidx.annotation.Keep
import com.facebook.drawee.backends.pipeline.Fresco
import com.goharsha.androild.fresco.FrescoImageLoader

@Keep
object AndroILD: AndroILDInterface<RequestBuilder> {
    override fun initialize(context: Context) {
        Fresco.initialize(context)
    }

    override fun newRequest(): RequestBuilder = RequestBuilder(null, FrescoImageLoader)
}