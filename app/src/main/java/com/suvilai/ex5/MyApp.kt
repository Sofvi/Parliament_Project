package com.suvilai.ex5

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.network.ApiClient
import com.suvilai.ex5.repository.GradeRepository
import com.suvilai.ex5.repository.MemberRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApp : Application() {


    companion object {
        lateinit var appContext: Context
    }

    private val appDatabase by lazy { MemberDatabase.getInstance(this) }

    val memberRepository by lazy {
        MemberRepository(ApiClient.retrofitService, appDatabase.memberDao())}

}



