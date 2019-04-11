package com.maple.xloader.app

import android.app.Application

/**
 * author: gaogq
 * time: 2019/4/11 13:28
 * description:
 */
class MyApplication:Application() {
    companion object {
        @JvmStatic lateinit var instance:MyApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}