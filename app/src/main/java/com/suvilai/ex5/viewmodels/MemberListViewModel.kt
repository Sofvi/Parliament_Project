package com.suvilai.ex5.viewmodels

import androidx.lifecycle.*
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



class MemberListViewModel(private val memberRepository: MemberRepository) : ViewModel(){

    val allMembers: LiveData<List<ParliamentMembers>> = memberRepository.getMembers()

    fun populate() {
        viewModelScope.launch(Dispatchers.IO) {
            val members = memberRepository.fetch()
            memberRepository.insert(*members.toTypedArray())
        }
    }
}

class MemberListViewModelFactory(private val memberRepository: MemberRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemberListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MemberListViewModel(memberRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
