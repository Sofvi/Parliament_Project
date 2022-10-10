package com.suvilai.ex5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suvilai.ex5.data.Comment
import com.suvilai.ex5.databinding.CommentItemBinding

/**     Suvi Laitinen, 10.10.2022
 *      2113710
 *
 *      RecyclerView Adapter for CommentFragment -class.
 *      Shows the list of all the comments and allows the user
 *      to add some.
 */

class CommentListAdapter : RecyclerView.Adapter<CommentListAdapter.ViewHolder>() {

    private var commentList = emptyList<Comment>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding = CommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: CommentItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(comment: Comment) {
            commentList = listOf(comment)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(commentList[position])
    }

    override fun getItemCount(): Int = commentList.size

}

