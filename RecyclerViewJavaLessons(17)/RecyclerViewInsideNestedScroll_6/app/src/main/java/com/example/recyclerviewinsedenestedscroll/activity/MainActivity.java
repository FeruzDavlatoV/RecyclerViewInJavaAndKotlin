package com.example.recyclerviewinsedenestedscroll.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerviewinsedenestedscroll.R;
import com.example.recyclerviewinsedenestedscroll.adapter.CustomAdapter;
import com.example.recyclerviewinsedenestedscroll.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    NestedScrollView nestedScrollView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initViews() {
        nestedScrollView = findViewById(R.id.nestedScrollView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members){
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

    }

    public List<Member> prepareMemberList(){
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i==2 || i == 7){
                members.add(new Member("Feruz","Davlatov"));
            }else {
                members.add(new Member("Firdavs", "Davlatov"));
            }
        }
        members.add(new Member());
        return members;
    }

}