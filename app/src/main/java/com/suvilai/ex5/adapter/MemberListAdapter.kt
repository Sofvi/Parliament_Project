package com.suvilai.ex5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.suvilai.ex5.R
import com.suvilai.ex5.data.ParliamentMembers

class MemberListAdapter : RecyclerView.Adapter<MemberListAdapter.MyViewHolder>() {

    private lateinit var dataset: List<ParliamentMembers>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //val currentItem = dataset[position]
        //holder.picture.setImageResource(currentItem.pictureUrl)
        //holder.fullName.text = currentItem.fullName()
        holder.fullName.text = dataset[position].toString()
    }
    override fun getItemCount() = dataset.size

    fun setData(member: List<ParliamentMembers>) {
        this.dataset = member
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        //val picture: ShapeableImageView = itemView.findViewById(R.id.pictureUrl)
        val fullName: TextView = itemView.findViewById(R.id.fullName_title)
    }
}