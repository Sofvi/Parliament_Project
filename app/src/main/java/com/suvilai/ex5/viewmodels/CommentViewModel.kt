package com.suvilai.ex5.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.adapter.CommentListAdapter
import com.suvilai.ex5.data.Comment
import com.suvilai.ex5.data.CommentDatabase
import com.suvilai.ex5.repository.CommentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      ViewModel for the CommentFragment
 */

class CommentViewModel : ViewModel() {
    private val repository: CommentRepository
    var adapter = CommentListAdapter()

    init {
        val commentDao = CommentDatabase.getInstance(MyApp.appContext).commentDao()
        repository = CommentRepository(commentDao)
    }

    fun addComment(comment: Comment) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addComment(comment)
        }
    }

}

class CommentViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CommentViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

