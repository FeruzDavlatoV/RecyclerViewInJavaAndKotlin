package com.example.recyclerviewcustombasicadapter_kotlin_1


import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList



class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var context: Context

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

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(context, members)
        recyclerView.adapter = adapter
    }


    fun prepareMemberList(): List<Member> {
        val members: MutableList<Member> = ArrayList()
        for (i in 0..19) {
            if (i == 0 || i == 5 || i == 10 || i == 15) {
                members.add(Member("Feruz", "Davlatov",true))
            } else {
                members.add(Member("Feruz", "Davlatov",false))
            }
        }
        return members
    }

}




