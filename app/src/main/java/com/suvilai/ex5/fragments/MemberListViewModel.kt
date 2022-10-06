package com.suvilai.ex5.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.suvilai.ex5.ParliamentMember

/*
class MemberListViewModel : ViewModel() {

    fun member(): List<String> {
        return ParliamentMember.ParliamentMembersData.members.map { it.fullName() }.toSet().toList().sorted()
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

 */