package com.suvilai.ex5.repository

import com.suvilai.ex5.data.MemberDao
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.network.ApiClient
import com.suvilai.ex5.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MemberRepository(private val api: ApiService, private val memberDao: MemberDao) {

    fun getMembers() = memberDao.getMembers()

    fun getParty(party: String) = memberDao.getParty(party)

    fun insert(vararg allMembers: ParliamentMembers) = memberDao.insert(*allMembers)

    suspend fun fetch(): List<ParliamentMembers> = api.getMemberList()

}