package com.suvilai.ex5.viewmodels

import androidx.lifecycle.*
import com.suvilai.ex5.MainActivity
import com.suvilai.ex5.MyApp.Companion.appContext
import com.suvilai.ex5.ParliamentMember.ParliamentMembersData.members
import com.suvilai.ex5.data.MemberDao
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.network.ApiService
import com.suvilai.ex5.repository.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemberListViewModel(private val memberRepository: MemberRepository) : ViewModel(){

    val parties = memberRepository.getMembers()

    val status = memberRepository
    /*
    fun getMembers() {
        memberRepository.getMembers()
    }

     */
}


class MemberListViewModelFactory(private val memberDao: MemberDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemberListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MemberListViewModel(MemberRepository(memberDao)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}