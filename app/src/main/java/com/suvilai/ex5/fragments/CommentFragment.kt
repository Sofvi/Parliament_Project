package com.suvilai.ex5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.R
import com.suvilai.ex5.adapter.CommentListAdapter
import com.suvilai.ex5.data.Comment
import com.suvilai.ex5.databinding.CommentFragmentBinding
import com.suvilai.ex5.viewmodels.CommentViewModel
import com.suvilai.ex5.viewmodels.CommentViewModelFactory

/**     Suvi Laitinen, 10.10.2022
*       2113710
*
*       The comment fragment of the application.
*       Allows to comment on member.
 *
 *       !Doesn't work right now! (10.10.22)
*/

private lateinit var binding: CommentFragmentBinding
private lateinit var adapter: CommentListAdapter

class CommentFragment : Fragment() {

    private val args by navArgs<CommentFragmentArgs>()

    // ViewModel
    private val commentViewModel : CommentViewModel by viewModels {
        CommentViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.comment_fragment,container,false)

        adapter = commentViewModel.adapter
        val recyclerView = binding.commentRecycler
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Tries to send the comment
        binding.sendComment.setOnClickListener {
            val commentText = binding.editComment.text.toString()
            val hetekaId = args.passComment.hetekaId
            commentViewModel.addComment(Comment(0,hetekaId,commentText))
            Toast.makeText(MyApp.appContext, "Comment added", Toast.LENGTH_LONG).show()
        }


        return binding.root
    }
}

