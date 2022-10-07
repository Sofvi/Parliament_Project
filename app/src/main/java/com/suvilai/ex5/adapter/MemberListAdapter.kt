package com.suvilai.ex5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.databinding.ListItemBinding


class MemberListAdapter(
    private val dataset: List<ParliamentMembers>,
) : RecyclerView.Adapter<MemberListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView: LayoutInflater = LayoutInflater.from(parent.context)

        val binding: ListItemBinding =
            ListItemBinding.inflate(itemView, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setViewHolderData(dataset[position])
    }
    override fun getItemCount() = dataset.size

    inner class MyViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root) {


        fun setViewHolderData(member: ParliamentMembers) {
            binding.member = member
        }


    }
}