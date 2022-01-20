package com.example.recyclerviewvinsiderecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewvinsiderecyclerview.R;
import com.example.recyclerviewvinsiderecyclerview.model.Member;
import com.example.recyclerviewvinsiderecyclerview.model.SubMember;

import java.util.List;

public class CustomSubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<SubMember> subMembers;

    public CustomSubAdapter(Context context, List<SubMember> subMembers) {
        this.context = context;
        this.subMembers = subMembers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view_sub,parent,false);
        return new CustomSubViewHolder(footer);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SubMember subMember = subMembers.get(position);

    }

    @Override
    public int getItemCount() {
        return subMembers.size();
    }


    //Holders Here
    public static class CustomSubViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public CustomSubViewHolder(View v){
            super(v);
            view = v;
        }
    }
}
