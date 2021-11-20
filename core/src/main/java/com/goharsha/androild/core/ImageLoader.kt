package com.goharsha.androild.core

fun interface ImageLoader<Source, Target> {
    fun loadInto(source: Source, into: Target)
}