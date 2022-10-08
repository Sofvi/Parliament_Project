package com.suvilai.ex5.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.distinctUntilChanged
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.suvilai.ex5.MyApp
import com.suvilai.ex5.R
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.databinding.FragmentMemberDetailsBinding
import com.suvilai.ex5.network.ImageApiService
import com.suvilai.ex5.viewmodels.MemberDetailsViewModel
import com.suvilai.ex5.viewmodels.MemberDetailsViewModelFactory
import kotlinx.android.synthetic.main.fragment_member_details.*


/**     Suvi Laitinen, 9.10.2022
 *      2113710
 *
 *      The member detail fragment of the application. Shows the details of
 *      the member pressed in the MemberListFragment RecyclerView.
 */

private lateinit var binding : FragmentMemberDetailsBinding
private lateinit var currentMember : ParliamentMembers

class MemberDetailsFragment : Fragment() {

    private val args by navArgs<MemberDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_member_details, container, false)

        currentMember = args.passData

        val callback: OnBackPressedCallback =
            object  : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_memberDetailsFragment_to_memberListFragment)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)

        getMember()

        return binding.root
    }

    // Finds a member from ParliamentMembers and shows the details
    private fun getMember() {
        val memb = currentMember
        binding.idView.text = (memb.hetekaId.toString())
        binding.seatView.text = (memb.seatNumber.toString())
        binding.ministerView.text = getMinistry(memb)
        Picasso.get().load("https://avoindata.eduskunta.fi/${memb.pictureUrl}").into(binding.imageView)
        binding.partyView.text = (memb.party)
        binding.nameView.text = (memb.fullname)
        //binding.txtAge.text = getString(R.string.years_old, (2021 - memb.bornYear))
        //binding.txtConstituency.text = memb.constituency
        //binding.pointView.text = currentPoints.toString()
    }

    // Check if the member is a minister
    private fun getMinistry(memb : ParliamentMembers) : String = if (memb.minister) "Minister" else " "

    //Provides pictures of members
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


