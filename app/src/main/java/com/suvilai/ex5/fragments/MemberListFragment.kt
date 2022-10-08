package com.suvilai.ex5.fragments

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.distinctUntilChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.R
import com.suvilai.ex5.adapter.MemberListAdapter
import com.suvilai.ex5.adapter.MyViewHolder
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.databinding.FragmentMemberListBinding
import com.suvilai.ex5.databinding.ListItemBinding
import com.suvilai.ex5.network.ImageApiService
import com.suvilai.ex5.viewmodels.MemberDetailsViewModel
import com.suvilai.ex5.viewmodels.MemberDetailsViewModelFactory
import com.suvilai.ex5.viewmodels.MemberListViewModel
import com.suvilai.ex5.viewmodels.MemberListViewModelFactory
import kotlinx.android.synthetic.main.fragment_member_list.*
import kotlinx.android.synthetic.main.list_item.*

/**     Suvi Laitinen, 5.10.2022
 *      2113710
 *
 *      The main fragment of the application. Shows a list of all the members in
 *      the parliament in a RecyclerView.
 */



class MemberListFragment : Fragment() {

    private lateinit var binding: FragmentMemberListBinding
    private lateinit var idk: ListItemBinding
    private lateinit var memberDetailsViewModel: MemberDetailsViewModel
    private lateinit var memberViewModel: MemberListViewModel

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

        memberViewModel = MemberListViewModel(application.memberRepository)
        memberDetailsViewModel = MemberDetailsViewModel(application.memberRepository)

       binding = FragmentMemberListBinding.inflate(inflater, container, false)
       idk = DataBindingUtil.inflate(inflater, R.layout.list_item, container, false)


        idk.listFrame.setOnClickListener {
            val action =
                MemberListFragmentDirections.actionMemberListFragmentToMemberDetailsFragment()
            findNavController().navigate(action)
        }



        memberViewModel.populate()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        memberViewModel.allMembers.distinctUntilChanged().observe(viewLifecycleOwner) { members ->
            this.memberRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            this.memberRecyclerView.adapter = MemberListAdapter(members)


            //MemberListAdapter.ParliamentMemberListener {
            //  this.findNavController().navigate(
            //    MemberListFragmentDirections.actionMemberListFragmentToMemberDetailsFragment()
            //)
            //})

        }

        //memberDetailsViewModel.populate()
    }


    /*
    override fun onParliamentMemberClick(v: View?, member: ParliamentMembers) {
        val action = MemberListFragmentDirections.actionMemberListFragmentToMemberDetailsFragment()
        findNavController().navigate(action)
    }

     */


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_nav, menu)

    }

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


