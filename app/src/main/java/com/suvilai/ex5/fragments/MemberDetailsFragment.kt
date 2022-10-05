package com.suvilai.ex5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.suvilai.ex5.ParliamentMember
import com.suvilai.ex5.R
import com.suvilai.ex5.databinding.FragmentMemberDetailsBinding

class MemberDetailsFragment : Fragment() {

    private var member: ParliamentMember? = null

    companion object {
        const val LETTER = "letter"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentMemberDetailsBinding = FragmentMemberDetailsBinding.inflate(inflater, container, false)
        binding.member = this.member

        return inflater.inflate(R.layout.fragment_member_details, container, false)
    }

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_member_details)

        val p = ParliamentMember.Parliament(ParliamentMember.ParliamentMembersData.members)

        val randomMember = (0..p.members.size).random()


        val name : TextView = findViewById(R.id.nameView)
        val id : TextView = findViewById(R.id.idView)
        val party : TextView = findViewById(R.id.partyView)
        val seat : TextView = findViewById(R.id.seatView)
        val minister : TextView = findViewById(R.id.ministerView)


        name.text = p.members[randomMember].fullName()
        id.text = p.members[randomMember].hetekaId.toString()
        party.text = p.members[randomMember].party
        seat.text = p.members[randomMember].seatNumber.toString()

        //shows if MP is a minister
        if (p.members[randomMember].minister) { "Minister".also { minister.text = it }
        } else {
            " ".also { minister.text = it }
        }
    }

     */
}