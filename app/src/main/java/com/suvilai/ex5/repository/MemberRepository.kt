package com.suvilai.ex5.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.suvilai.ex5.data.MemberDao
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.network.ApiService

class MemberRepository(private val memberDao: MemberDao) {

    fun getMembers() = memberDao.getMembers()

}