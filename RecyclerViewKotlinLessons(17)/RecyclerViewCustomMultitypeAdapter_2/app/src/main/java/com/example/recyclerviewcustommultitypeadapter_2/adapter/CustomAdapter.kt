package com.example.recyclerviewcustommultitypeadapter_2.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcustommultitypeadapter_2.R
import com.example.recyclerviewcustommultitypeadapter_2.model.Member

class CustomAdapter(val context: Context, private val members: List<com.example.recyclerviewcustommultitypeadapter_2.model.Member>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_AVAILABLE_YES = 0;
    private val TYPE_AVAILABLE_NO = 1;

    override fun getItemViewType(position: Int): Int {
        val member: Member = members[position]
        return if (member.available) {
            TYPE_AVAILABLE_YES
        } else TYPE_AVAILABLE_NO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_AVAILABLE_YES) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_yes, parent, false)
            return CustomViewYesHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout_no, parent, false)
            return CustomViewNoHolder(view)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if (holder is CustomViewYesHolder) {

            holder.apply {

                first_name.text = member.firsName
                last_name.text = member.lastName

            }
        }

        if (holder is CustomViewNoHolder) {
            holder.apply {

                first_name.text = "This firstName is not available"
                last_name.text = "This firstName is not available"

            }
        }

    }

    override fun getItemCount(): Int {
        return members.size
    }


    //Holders
    class CustomViewYesHolder(var view: View) : RecyclerView.ViewHolder(
        view
    ) {
        var first_name: TextView
        var last_name: TextView

        init {
            first_name = view.findViewById(R.id.first_name)
            last_name = view.findViewById(R.id.last_name)
        }
    }

    class CustomViewNoHolder(var view: View) : RecyclerView.ViewHolder(
        view
    ) {
        var first_name: TextView
        var last_name: TextView

        init {
            first_name = view.findViewById(R.id.first_name)
            last_name = view.findViewById(R.id.last_name)
        }
    }
}