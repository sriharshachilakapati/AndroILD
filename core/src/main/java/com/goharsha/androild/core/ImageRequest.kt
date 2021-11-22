package com.goharsha.androild.core

data class ImageRequest(
    val imageSource: ImageSource? = null,
    val width: Int = ORIGINAL_SIZE,
    val height: Int = ORIGINAL_SIZE
) {
    companion object {
        const val ORIGINAL_SIZE = -1
    }
}
