package com.suvilai.ex5

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.databinding.ActivityMainBinding

/**     Suvi Laitinen,  5.10.2022
 *      2113710
 *
 *      MainActivity class for the app
 */

class MainActivity : AppCompatActivity() {

    //private val periodicWorkRequest = PeriodicWorkRequestBuilder<DownloadWorker>(24, TimeUnit.HOURS).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //WorkManager.getInstance(MyApp.appContext).enqueueUniquePeriodicWork("updateMembers", ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest)

        //setupActionBarWithNavController(findNavController(R.id.fragmentContainerView))
    }

}