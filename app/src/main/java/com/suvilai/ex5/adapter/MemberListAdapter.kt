package com.suvilai.ex5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.databinding.FragmentMemberListBinding


class MemberListAdapter(
    private val dataset: List<ParliamentMembers>
) : RecyclerView.Adapter<MemberListAdapter.MyViewHolder>() {

    //private var dataset = emptyList<ParliamentMembers>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView: LayoutInflater = LayoutInflater.from(parent.context)

        val binding: FragmentMemberListBinding =
            FragmentMemberListBinding.inflate(itemView, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.fullName.text = dataset[position].toString()
        holder.setViewHolderData(dataset[position])
    }
    override fun getItemCount() = dataset.size

    inner class MyViewHolder(val binding: FragmentMemberListBinding):RecyclerView.ViewHolder(binding.root) {
        //val fullName: TextView = itemView.findViewById(R.id.fullName_title)


        fun setViewHolderData(member: ParliamentMembers) {
            this.member = member
        }


    }
}