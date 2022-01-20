package com.example.recyclerviewcustomadapterloadingmore.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.recyclerviewcustomadapterloadingmore.Member.Member;
import com.example.recyclerviewcustomadapterloadingmore.R;
import com.example.recyclerviewcustomadapterloadingmore.adapter.CustomAdapter;
import com.example.recyclerviewcustomadapterloadingmore.listener.OnBottomReachedListener;

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

        List<Member> members = prepareMemberList();
        refreshAdapter(members);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members){
       CustomAdapter adapter = new CustomAdapter(context,members, new OnBottomReachedListener() {
           @Override
           public void onBottomReached(int position) {
//               Log.d("@@@", "@@@position" + position);
      //         Toast.makeText(context, "Loading More..." + position, Toast.LENGTH_SHORT).show();
           }
       });
       recyclerView.setAdapter(adapter);
    }

    List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        members.add(new Member());
        for (int i = 0; i < 20; i++) {
            if (i==0 || i==5 || i == 10 || i == 15){
                members.add(new Member("Feruz", "Davlatov",false));
            } else {
                members.add(new Member("Feruz", "Davlatov",true));
            }
        }
        members.add(new Member());
        return members;
    }

}