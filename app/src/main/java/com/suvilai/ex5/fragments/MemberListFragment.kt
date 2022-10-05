package com.suvilai.ex5.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.suvilai.ex5.R
import com.suvilai.ex5.adapter.ItemAdapter
import com.suvilai.ex5.databinding.FragmentMemberListBinding

private lateinit var binding: FragmentMemberListBinding
@SuppressLint("StaticFieldLeak")
private lateinit var adapter: ItemAdapter

class MemberListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_member_list, container, false)

        adapter = ItemAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        /*
        getList()
        setHasOptionsMenu(true)

         */

        return binding.root
    }

}