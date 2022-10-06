package com.suvilai.ex5
/*
import android.app.Application
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.network.ApiClient
import com.suvilai.ex5.repository.MemberRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class App : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())
    private val appDatabase by lazy { MemberDatabase.getInstance(this, applicationScope) }

    val memberRepository by lazy { MemberRepository(ApiClient.retrofitService, appDatabase.memberDao()) }
}

 */