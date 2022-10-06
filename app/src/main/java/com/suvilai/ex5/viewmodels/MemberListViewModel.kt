package com.suvilai.ex5.viewmodels

import androidx.lifecycle.*
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.repository.MemberRepository

class MemberListViewModel : ViewModel(){

    private val memberRepository: MemberRepository

    fun getMembers() = memberRepository.getMembers()

    init {
        val memberDao = MemberDatabase.getInstance(MyApp.appContext).memberDao()
        memberRepository = MemberRepository(memberDao)
    }

}


class MemberListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemberListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MemberListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}