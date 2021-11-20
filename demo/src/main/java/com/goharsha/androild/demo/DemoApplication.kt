package com.goharsha.androild.demo

import android.app.Application
import com.goharsha.androild.core.AndroILD

class DemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroILD.initialize(this)
    }
}