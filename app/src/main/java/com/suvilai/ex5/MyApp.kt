package com.suvilai.ex5

import android.app.Application
import android.content.Context
import android.content.res.Resources

class MyApp : Application() {
    companion object {
        lateinit var appContext: Context
        lateinit var appResources: Resources
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        appResources = resources
    }
}