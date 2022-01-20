package com.example.recyclerviewcustombasicadapter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.example.recyclerviewcustombasicadapter.BuildConfig;
import com.example.recyclerviewcustombasicadapter.R;
import com.example.recyclerviewcustombasicadapter.adapter.CustomAdapter;
import com.example.recyclerviewcustombasicadapter.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initView();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);

    }

    private void initView(){
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1,GridLayoutManager.VERTICAL,false));
    }

    private void refreshAdapter(List<Member> members){
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList(){

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            members.add(new Member("Feruz\n"  + "Davlatov" ));
        }
        return members;
    }
}