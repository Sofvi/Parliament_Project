package com.suvilai.ex5.viewmodels
/*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.adapter.CommentListAdapter
import com.suvilai.ex5.data.MemberDatabase
import com.suvilai.ex5.repository.CommentRepository

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      ViewModel for the CommentFragment
 */


class CommentViewModel : ViewModel() {
    private val repository: CommentRepository
    var adapter = CommentListAdapter()
    var commentsSelected : Boolean = false

    init {
        val memberDao = MemberDatabase.getInstance(MyApp.appContext).memberDao()
        repository = CommentRepository(memberDao)
    }

    fun getCommentsForMember(hetekaId: Int) = repository.getCommentsForMember(hetekaId)

    fun getSelectedCommentsLiveData() = adapter.selectedCommentsLiveData

    fun getSelectedCommentsList() = adapter.selectedCommentsList

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

 */