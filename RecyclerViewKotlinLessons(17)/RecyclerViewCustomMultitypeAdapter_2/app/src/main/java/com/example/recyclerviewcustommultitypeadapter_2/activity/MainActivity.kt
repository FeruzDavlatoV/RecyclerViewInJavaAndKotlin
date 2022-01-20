package com.example.recyclerviewcustommultitypeadapter_2.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewcustommultitypeadapter_2.R
import com.example.recyclerviewcustommultitypeadapter_2.adapter.CustomAdapter
import java.lang.reflect.Member
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val member = prepareMemberList()
        refreshAdapter(member)
    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 1)
    }

    private fun refreshAdapter(members: List<com.example.recyclerviewcustommultitypeadapter_2.model.Member>) {
        val adapter = CustomAdapter(context, members)
        recyclerView.adapter = adapter
    }

    private fun prepareMemberList(): ArrayList<com.example.recyclerviewcustommultitypeadapter_2.model.Member> {
        val members = ArrayList<com.example.recyclerviewcustommultitypeadapter_2.model.Member>()
        for (i in 0..20){
            if (i == 0 || i == 5 || i == 10 || i == 15) {
                members.add(com.example.recyclerviewcustommultitypeadapter_2.model.Member("Feruz", "Davlatov", true))
            } else {
                members.add(com.example.recyclerviewcustommultitypeadapter_2.model.Member("Feruz", "Davlatov", false))
            }
        }
        return members
    }
}