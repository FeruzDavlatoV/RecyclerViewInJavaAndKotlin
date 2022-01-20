package com.example.recyclerviewvinsiderecyclerview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewvinsiderecyclerview.R;
import com.example.recyclerviewvinsiderecyclerview.model.Member;
import com.example.recyclerviewvinsiderecyclerview.model.SubMember;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        if (members.get(position).getSubMembers() != null) return TYPE_ITEM_LIST;

        return TYPE_ITEM_VIEW;

    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_LIST){
            View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_list,parent,false);
            return new CustomListHolder(header);
        }
        View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_view,parent,false);
        return new CustomViewHolder(header);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            Member member = members.get(position);

            if (holder instanceof CustomViewHolder){

            }

            if (holder instanceof CustomListHolder){

                RecyclerView recyclerView = ((CustomListHolder) holder).recyclerView;
                recyclerView.setLayoutManager(new GridLayoutManager(context,1, GridLayoutManager.HORIZONTAL, false));

                List<SubMember> subMembers = member.getSubMembers();
                refreshSubAdapter(recyclerView,subMembers);
            }
    }
    private void refreshSubAdapter(RecyclerView recyclerView,List<SubMember> subMembers){
        CustomSubAdapter adapter = new CustomSubAdapter(context,subMembers);
        recyclerView.setAdapter(adapter);
    }




    //Holders Here


    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        TextView textView;

        public CustomViewHolder(View v) {
            super(v);
            view = v;
            textView = v.findViewById(R.id.tv_header);
        }
    }
    public static class CustomListHolder extends RecyclerView.ViewHolder{
        public View view;
        public RecyclerView recyclerView;

        public CustomListHolder(View v) {
            super(v);
            view = v;
            //Add your UI Component here
            recyclerView = this.view.findViewById(R.id.recyclerView11);
        }
    }

}
