package com.suvilai.ex5.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import com.suvilai.ex5.R
import com.suvilai.ex5.adapter.MemberListAdapter
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.databinding.FragmentMemberListBinding
import com.suvilai.ex5.viewmodels.MemberListViewModel
import com.suvilai.ex5.viewmodels.MemberListViewModelFactory
import kotlinx.android.synthetic.main.list_item.*

/**     Suvi Laitinen, 5.10.2022
 *      2113710
 *
 *      The main fragment of the application. Shows a list of all the members in
 *      the parliament in a RecyclerView.
 */


private lateinit var binding: FragmentMemberListBinding
private lateinit var adapter: MemberListAdapter

class MemberListFragment : Fragment() {

    private val memberViewModel : MemberListViewModel by viewModels {
        MemberListViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_member_list, container, false)

        adapter = MemberListAdapter()
        val recyclerView = binding.memberRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //memberViewModel.getMembers()

        memberViewModel.populate()

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_nav, menu)

    }

    /*
    override fun onParliamentMemberClick(v: View?, member: ParliamentMembers) {
        val action = MemberListFragment.toMemberDetailsFragment(member.hetekaId)
        findNavController().navigate(action)
    }

     */

    /*
    companion object {
        @JvmStatic
        @BindingAdapter("loadListItemImage")
        fun loadListItemImage(view: ImageView, imageId: String?) {
            Glide.with(view.context)
                .load(ImageApiService.imageUrlBuilder(imageId))
                .override(300, 300)
                .fitCenter()
                .circleCrop()
                .into(view)
        }
    }

     */

    /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //takes data from manual class
        val data = Datasource().member()

        adapter = MemberListAdapter(data)
        val recyclerView = binding.memberRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

         */

}
