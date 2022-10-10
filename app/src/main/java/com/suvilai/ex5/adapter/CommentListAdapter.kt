/*
package com.suvilai.ex5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.suvilai.ex5.data.Comment
import com.suvilai.ex5.databinding.CommentFragmentBinding

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      RecyclerView Adapter for CommentFragment -class.
 *      Shows the list of all the comments and allows the user
 *      to add some.
 */

class CommentListAdapter : RecyclerView.Adapter<CommentListAdapter.ViewHolder>() {

    private var commentList = emptyList<Comment>()
    val selectedCommentsLiveData = MutableLiveData<MutableList<Comment>>()
    val selectedCommentsList = mutableListOf<Comment>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = CommentFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: CommentFragmentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(commentList[position]) {
                setUnselectedView(binding.commentTextView, this)
                binding.comment_.text = this.content
                binding.singleListComment.setOnLongClickListener {
                    setSelectedView(it, this)
                    true
                }
                binding.singleListComment.setOnClickListener {
                    if (this in selectedCommentsList) setUnselectedView(it, this)
                    else if (this !in selectedCommentsList && selectedCommentsList.isNotEmpty()) {
                        setSelectedView(it, this)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = commentList.size
}

 */