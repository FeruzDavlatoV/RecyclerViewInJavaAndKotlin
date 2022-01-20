package com.example.recyclerviewvinsiderecyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerviewvinsiderecyclerview.R;
import com.example.recyclerviewvinsiderecyclerview.adapter.CustomAdapter;
import com.example.recyclerviewvinsiderecyclerview.model.Member;
import com.example.recyclerviewvinsiderecyclerview.model.SubMember;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;
        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members){
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList(){

        List<Member> members = new ArrayList<>();
        members.add(new Member()); //For Header

        for (int i = 1; i < 21; i++) {
            if (i==1 || i==10){
                members.add(new Member("Feruz","Davlatov",prepareSubMembers()));
            } else {
                members.add(new Member("Feruz", "Davlatov",null));
            }
        }
        members.add(new Member());
        return members;
    }
    private List<SubMember> prepareSubMembers(){
        List<SubMember> members = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            members.add(new SubMember());
        }
        return members;
    }



}