package com.suvilai.ex5.network

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.repository.MemberRepository

private lateinit var repository: MemberRepository
/*
class WorkManager(appContext: Context, workerParams: WorkerParameters) :
CoroutineWorker(appContext, workerParams) {

    //val memberDao = MemberDatabase.getInstance(MyApp.appContext).memberDao()
    //private val repository: MemberRepository = MemberRepository(memberDao)

    override suspend fun doWork(): Result {
        repository.addMembers()
        return Result.success()
    }
}

 */

