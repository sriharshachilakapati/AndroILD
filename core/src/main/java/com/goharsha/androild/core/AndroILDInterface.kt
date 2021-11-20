package com.goharsha.androild.core

import android.content.Context

interface AndroILDInterface<RequestBuilder> {
    fun newRequest(): RequestBuilder
    fun initialize(context: Context)
}