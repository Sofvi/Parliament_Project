package com.suvilai.ex5.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.suvilai.ex5.MainActivity
import com.suvilai.ex5.R
import com.suvilai.ex5.fragments.MemberDetailsFragment

class ItemAdapter(
   //private var context: Context,
   private val dataset: List<String>,
   //private val onParliamentClickListener: View.OnClickListener
):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textView.text = dataset[position]
        //holder.setViewHolderData(dataset[position], this.onParliamentClickListener, position)

        /*
        holder.textView.setOnClickListener{
            context = holder.itemView.context
            val intent = Intent(context, MemberDetailsFragment::class.java)
            intent.putExtra(MemberDetailsFragment.LETTER, holder.textView.text.toString())
            context.startActivity(intent)
        }

         */

        /*
        holder.textView.setOnClickListener { Toast.makeText(this.context, "You clicked ${dataset[position]}", Toast.LENGTH_SHORT).show()

        holder.textView.setBackgroundColor(Color.parseColor("#ECECEC"))}
        }

         */

    }
    override fun getItemCount() = dataset.size
}