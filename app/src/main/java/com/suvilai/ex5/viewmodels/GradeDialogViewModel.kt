package com.suvilai.ex5.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.data.Grade
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.repository.GradeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GradeDialogViewModel : ViewModel() {
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

class GradeDialogViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GradeDialogViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return GradeDialogViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}