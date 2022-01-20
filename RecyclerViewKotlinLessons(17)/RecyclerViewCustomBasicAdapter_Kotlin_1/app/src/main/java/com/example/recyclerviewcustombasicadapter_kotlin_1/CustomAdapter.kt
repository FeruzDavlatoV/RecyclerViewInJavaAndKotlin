package com.example.recyclerviewcustombasicadapter_kotlin_1


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class CustomAdapter(val context: Context, private val members: List<Member>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if (holder is ItemViewHolder) {
            holder.apply {

                firstName.text = member.firsName
                lastName.text = member.lastName

            }
        }

    }

    override fun getItemCount(): Int {
        return members.size
    }


}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val firstName: TextView = view.findViewById(R.id.last_name)
    val lastName: TextView = view.findViewById(R.id.first_name)


}
