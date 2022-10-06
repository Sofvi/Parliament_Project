package com.suvilai.ex5.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.suvilai.ex5.data.MemberDao
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.network.ApiService

class MemberRepository(private val memberDao: MemberDao) {

    private val _status = MutableLiveData<ApiService>()

    val status: LiveData<ApiService>
    get() = status

    init {
        _status.postValue(ApiService.LOADING)
    }

    //fun getMembers() = memberDao.getMembers()

}