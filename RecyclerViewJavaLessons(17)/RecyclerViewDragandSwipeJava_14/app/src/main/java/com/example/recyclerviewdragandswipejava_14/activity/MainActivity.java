package com.example.recyclerviewdragandswipejava_14.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.recyclerviewdragandswipejava_14.R;
import com.example.recyclerviewdragandswipejava_14.adapter.CustomAdapter;
import com.example.recyclerviewdragandswipejava_14.model.Member;
import com.example.recyclerviewdragandswipejava_14.helper.SimpleItemTouchHelperCallBack;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = prepareList();
        refreshAdapter(members);

    }

    void initViews() {
        context = this;
        rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new GridLayoutManager(context, 2));
    }

    void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members);
        rvMain.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallBack(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(rvMain);
    }

    List<Member> prepareList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            members.add(new Member("Feruz " + i));
        }
        return members;
    }
}