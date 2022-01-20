package com.example.recyclerviewpinterestcells.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerviewpinterestcells.R;
import com.example.recyclerviewpinterestcells.adapter.CustomAdapter;
import com.example.recyclerviewpinterestcells.helper.SpaceItemDecoration;
import com.example.recyclerviewpinterestcells.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Member> member = prepareMemberList();
        refreshAdapter(member);

    }

    public void initViews(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        SpaceItemDecoration decoration = new SpaceItemDecoration(1);
        recyclerView.addItemDecoration(decoration);
    }

    private void refreshAdapter(List<Member> members){
        CustomAdapter adapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            members.add(new Member("Davlatov " + i, "Feruz "+i));
        }
        return members;
    }
}