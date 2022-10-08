package com.suvilai.ex5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.distinctUntilChanged
import com.bumptech.glide.Glide
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.R
import com.suvilai.ex5.databinding.FragmentMemberDetailsBinding
import com.suvilai.ex5.network.ImageApiService
import com.suvilai.ex5.viewmodels.MemberDetailsViewModel
import com.suvilai.ex5.viewmodels.MemberDetailsViewModelFactory


private lateinit var binding: FragmentMemberDetailsBinding
//private lateinit var memberViewModel: MemberListViewModel
private lateinit var memberDetailsViewModel: MemberDetailsViewModel

class MemberDetailsFragment : Fragment() {

    // App
    private val application by lazy { requireActivity().application as MyApp }

    //ViewModel
    //private val memberViewModel : MemberListViewModel by viewModels {
    //  MemberListViewModelFactory(application.memberRepository) }
    //private val memberDetailsViewModel : MemberDetailsViewModel by viewModels {
    //  MemberDetailsViewModelFactory(application.memberRepository) }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //memberViewModel = ViewModelProvider(this)[MemberListViewModel::class.java]
        memberDetailsViewModel = MemberDetailsViewModel(application.memberRepository)

        binding = FragmentMemberDetailsBinding.inflate(inflater,container,false)

        memberDetailsViewModel.populate()

        return binding.root
    }

    /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        memberDetailsViewModel.allMembers.distinctUntilChanged().observe(viewLifecycleOwner) { members ->
            binding.memberDetails = members.find { it.minister }
        }
    }

     */

    companion object {
        @JvmStatic
        @BindingAdapter("loadListItemImage")
        fun loadListItemImage(view: ImageView, imageId: String?) {
            Glide.with(view.context)
                .load(ImageApiService.imageBuilder(imageId))
                .override(500, 500)
                .into(view)
        }
    }
}


