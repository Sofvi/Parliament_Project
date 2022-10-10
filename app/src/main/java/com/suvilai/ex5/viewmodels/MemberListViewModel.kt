package com.suvilai.ex5.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.repository.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**     Suvi Laitinen, 8.10.2022
 *      2113710
 *
 *      ViewModel for the MemberListFragment.
 */

class MemberListViewModel : ViewModel(){

    private val memberRepository: MemberRepository

    init {
        val memberDao = MemberDatabase.getInstance(MyApp.appContext).memberDao()
        memberRepository = MemberRepository(memberDao)
    }

    val allMembers: LiveData<List<ParliamentMembers>> = memberRepository.getMembers()


    fun fillMembers() {
        viewModelScope.launch(Dispatchers.IO) {
            val members = memberRepository.fetch()
            memberRepository.insert(*members.toTypedArray())
        }
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
