package com.suvilai.ex5.network

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.repository.MemberRepository

/**     Suvi Laitinen. 10.10.2022
 *      2113710
 *
 *      WorkManager for getting parliament members from database
 */

class WorkManager(appContext: Context, workerParams: WorkerParameters) :
CoroutineWorker(appContext, workerParams) {

    private val memberDao = MemberDatabase.getInstance(MyApp.appContext).memberDao()
    private val repository: MemberRepository = MemberRepository(memberDao)

    override suspend fun doWork(): Result {
        repository.getMembers()
        return Result.success()
    }
}



