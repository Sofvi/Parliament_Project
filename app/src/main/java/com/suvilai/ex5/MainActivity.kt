package com.suvilai.ex5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

/**     Suvi Laitinen,  5.10.2022
 *      2113710
 *
 *      MainActivity class for the app
 */

class MainActivity : AppCompatActivity() {

    //private val periodicWorkRequest = PeriodicWorkRequestBuilder<DownloadWorker>(24, TimeUnit.HOURS).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        //WorkManager.getInstance(MyApp.appContext).enqueueUniquePeriodicWork("updateMembers", ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest)

        //setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
    }

}