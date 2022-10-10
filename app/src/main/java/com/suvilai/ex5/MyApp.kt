package com.suvilai.ex5

import android.app.Application
import android.content.Context
import android.content.res.Resources

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      The Application class for the app.
 *      Gives access to app context.
 */

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



