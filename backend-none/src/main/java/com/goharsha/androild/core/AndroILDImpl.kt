package com.goharsha.androild.core

fun throwNotImplementedError(): Nothing =
    throw NotImplementedError("Backend 'None' doesn't implement anything")

object AndroILDImpl : AndroILDInterface {
    override fun initialize() {
        throwNotImplementedError()
    }
}