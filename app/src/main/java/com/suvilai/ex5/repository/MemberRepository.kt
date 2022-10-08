package com.suvilai.ex5.repository

import android.util.Log
import com.suvilai.ex5.data.MemberDao
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.network.ApiClient
import com.suvilai.ex5.network.ApiService

/**     Suvi Laitinen, 8.10.2022
 *      2113710
 *
 *      Repository class for the ParliamentMembers -table in RoomDB
 */

class MemberRepository(private val api: ApiService, private val memberDao: MemberDao) {

    fun getMembers() = memberDao.getMembers()

    //fun getParty(party: String) = memberDao.getParty(party)

    fun insert(vararg allMembers: ParliamentMembers) = memberDao.insert(*allMembers)

    suspend fun fetch(): List<ParliamentMembers> = api.getMemberList()

    /*
    suspend fun addMembers() {
        try {
            val memberListResult = ApiClient.retrofitService.getMemberList()
            println(memberListResult)

            for (member in memberListResult) {
                /*
                This score below can be null, regardless of what the IDE says. When updating the list, we'll
                check if there isn't a score saved for this member and if so, we'll create it. This
                prevents scores from being wiped away every time the WorkManager downloads an updated
                member list.
                 */
                memberDao.addMember(member)
            }
        } catch (e: Exception) {
            Log.i("Json call", "Error: ${e}, Failed miserably.")
        }
    }

     */

}