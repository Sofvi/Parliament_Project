package com.suvilai.ex5.repository

import com.suvilai.ex5.data.MemberDao
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.network.ApiService

class MemberRepository(private val api: ApiService, private val memberDao: MemberDao) {

    fun getMembers() = memberDao.getMembers()

    //fun insert(vararg allMembers: ParliamentMembers) = memberDao.insert(*allMembers)

    suspend fun fetch(): List<ParliamentMembers> = api.getMemberList()
}