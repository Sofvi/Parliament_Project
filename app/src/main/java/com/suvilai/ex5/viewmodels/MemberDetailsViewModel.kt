package com.suvilai.ex5.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.repository.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MemberDetailsViewModel(private val memberRepository: MemberRepository) : ViewModel() {

    val allMembers: LiveData<List<ParliamentMembers>> = memberRepository.getMembers()

    fun populate() {
        viewModelScope.launch(Dispatchers.IO) {
            val members = memberRepository.fetch()
            memberRepository.insert(*members.toTypedArray())
        }
    }
}

class MemberDetailsViewModelFactory(private val memberRepository: MemberRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemberListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MemberDetailsViewModel(memberRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}