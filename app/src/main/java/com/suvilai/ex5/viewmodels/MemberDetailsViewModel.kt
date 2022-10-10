package com.suvilai.ex5.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.data.Grade
import com.suvilai.ex5.data.GradeDatabase
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.repository.GradeRepository
import com.suvilai.ex5.repository.MemberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**     Suvi Laitinen, 8.10.2022
 *      2113710
 *
 *      ViewModel fot the MemberDetailsFragment.
 */

class MemberDetailsViewModel : ViewModel() {
    private val memberRepository: MemberRepository
    private val gradeRepository: GradeRepository


    init {
        val memberDao = MemberDatabase.getInstance(MyApp.appContext).memberDao()
        memberRepository = MemberRepository(memberDao)

        val gradeDao = GradeDatabase.getInstance(MyApp.appContext).gradeDao()
        gradeRepository = GradeRepository(gradeDao)
    }
}

class MemberDetailsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MemberListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MemberDetailsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}