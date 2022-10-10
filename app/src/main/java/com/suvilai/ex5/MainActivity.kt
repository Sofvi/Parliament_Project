package com.suvilai.ex5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import com.suvilai.ex5.databinding.ActivityMainBinding
import com.suvilai.ex5.network.WorkManager
import kotlinx.android.synthetic.main.fragment_member_details.*
import kotlinx.android.synthetic.main.fragment_member_list.*
import java.util.concurrent.TimeUnit

/**     Suvi Laitinen,  5.10.2022
 *      2113710
 *
 *      MainActivity class for the app
 */

class MainActivity : AppCompatActivity() {

    private val periodicWorkRequest = PeriodicWorkRequestBuilder<WorkManager>(24, TimeUnit.HOURS).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        androidx.work.WorkManager.getInstance(MyApp.appContext).enqueueUniquePeriodicWork("updateMembers", ExistingPeriodicWorkPolicy.KEEP, periodicWorkRequest)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbar)
        setSupportActionBar(my_toolbar)
    }

}