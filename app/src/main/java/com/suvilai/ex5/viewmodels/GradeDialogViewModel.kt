package com.suvilai.ex5.viewmodels


import androidx.lifecycle.*
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.data.*
import com.suvilai.ex5.repository.GradeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**     Suvi Laitinen, 8.10.2022
 *      2113710
 *
 *      ViewModel for GradeDialogFragment.
 */

class GradeDialogViewModel : ViewModel() {
    private val gradeRepository: GradeRepository

    init {
        val gradeDao = GradeDatabase.getInstance(MyApp.appContext).gradeDao()
        gradeRepository = GradeRepository(gradeDao)
    }


    fun updateGrade(grade: Grade) {
        viewModelScope.launch(Dispatchers.IO) {
            gradeRepository.updateGrade(grade)
        }
    }
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

