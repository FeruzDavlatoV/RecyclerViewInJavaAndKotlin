package com.example.recyclerviewpinterestcells.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewpinterestcells.R;
import com.example.recyclerviewpinterestcells.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout, parent,false);
        return new  CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CustomViewHolder){
          if (position % 3 == 0){
              ((CustomViewHolder) holder).item_image.setImageResource(R.drawable.im_sample_1);
          }else if (position % 4 == 0){
              ((CustomViewHolder) holder).item_image.setImageResource(R.drawable.im_sample_2);
          }else {
              ((CustomViewHolder) holder).item_image.setImageResource(R.drawable.im_sample_3);
          }
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{
        private View view;
        private ImageView item_image;

        public CustomViewHolder(@NonNull View v) {
            super(v);
            view = v;
            item_image = view.findViewById(R.id.item_image);
        }
    }
}
