package com.suvilai.ex5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suvilai.ex5.data.ParliamentMembers
import com.suvilai.ex5.databinding.ListItemBinding


class MemberListAdapter(
    private val dataset: List<ParliamentMembers>
) : RecyclerView.Adapter<MyViewHolder>() {

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
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size
}



    class MyViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root) {

        /*
        init {
            binding.root.setOnClickListener(this)
        }

         */

        /*
        lateinit var listener: OnParliamentMemberClickListener
        lateinit var index: Number

         */

        fun bind(member: ParliamentMembers) {
            binding.member = member
        }

        /*
        override fun onClick(v: View?) {
            this.listener.onParliamentMemberClick(v, binding.member!!)
        }

        companion object {
            interface OnParliamentMemberClickListener {
                fun onParliamentMemberClick(v: View?, member: ParliamentMembers)
            }
        }

         */
    }
