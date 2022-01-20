package com.example.recyclerviewdragandswipejava_14.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewdragandswipejava_14.R;
import com.example.recyclerviewdragandswipejava_14.helper.ItemTouchHelperAdapter;
import com.example.recyclerviewdragandswipejava_14.model.Member;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchHelperAdapter {

    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);

        if (holder instanceof CustomViewHolder) {
            ((CustomViewHolder) holder).tvNAme.setText(member.getName());
        }

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(members, i, i + 1);
            }
        }else {
            for (int i = fromPosition; i > toPosition ; i--) {
                Collections.swap(members, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);

    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onItemDismiss(int position) {
        members.remove(position);
        notifyItemRemoved(position);

    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView tvNAme;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            tvNAme = view.findViewById(R.id.tv_name);
        }
    }
}
