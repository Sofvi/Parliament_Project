package com.suvilai.ex5.repository

import com.suvilai.ex5.data.MemberDao
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.network.ApiClient

/**     Suvi Laitinen, 8.10.2022
 *      2113710
 *
 *      Repository class for the ParliamentMembers -table in RoomDB
 */

class MemberRepository(private val memberDao: MemberDao) {

    fun getMembers() = memberDao.getMembers()

    fun insert(vararg allMembers: ParliamentMembers) = memberDao.insert(*allMembers)

    suspend fun fetch() = ApiClient.retrofitService.getMemberList()
}