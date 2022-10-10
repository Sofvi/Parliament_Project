package com.suvilai.ex5.fragments

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.suvilai.ex5.R
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.databinding.FragmentMemberDetailsBinding
import com.suvilai.ex5.network.ImageApiService


/**     Suvi Laitinen, 9.10.2022
 *      2113710
 *
 *      The member detail fragment of the application. Shows the details of
 *      the member pressed in the MemberListFragment RecyclerView.
 */

private lateinit var binding : FragmentMemberDetailsBinding
lateinit var currentMember : ParliamentMembers

class MemberDetailsFragment : Fragment() {

    private val args by navArgs<MemberDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_member_details, container, false)

        currentMember = args.passData

        getMember()

        binding.bottomNavDetails.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.like -> {
                    findNavController().navigate(R.id.gradeDialogFragment)
                    true
                }
                R.id.comment -> {
                    findNavController().navigate(R.id.commentFragment)
                    true
                }
                else -> {
                    false
                }
            }
        }

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_nav_details, menu)

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


