package com.suvilai.ex5.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.repository.GradeRepository


class MemberDetailsViewModel : ViewModel() {

    private val gradeRepository: GradeRepository


    init {
        val memberDao = MemberDatabase.getInstance(MyApp.appContext).memberDao()
        gradeRepository = GradeRepository(memberDao)
    }

    /*
    fun updateGrade(grade: Grade) {
        viewModelScope.launch(Dispatchers.IO) {
            gradeRepository.updateGrade(grade)
        }
    }

    fun getCurrentGrade(hetekaId: Int) = gradeRepository.getCurrentGrade(hetekaId)

     */

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