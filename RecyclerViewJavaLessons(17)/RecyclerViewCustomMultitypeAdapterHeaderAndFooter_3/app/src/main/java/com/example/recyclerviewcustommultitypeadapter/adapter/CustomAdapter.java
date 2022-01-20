package com.example.recyclerviewcustommultitypeadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewcustommultitypeadapter.Member.Member;
import com.example.recyclerviewcustommultitypeadapter.R;

import java.util.List;

public class CustomAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int TYPE_ITEM_HEADER = 0;
    private final int TYPE_ITEM_YES_VIEW = 1;
    private final int TYPE_ITEM_NOT_VIEW= 2;
    private final int TYPE_ITEM_FOOTER = 3;

    private Context context;
    private final List<Member> members;

    public CustomAdapter(Context context,List<com.example.recyclerviewcustommultitypeadapter.Member.Member> members){
        this.context = context;
        this.members = members;
    }


    @Override
    public int getItemViewType(int position) {

        if (isHeader(position)) return TYPE_ITEM_HEADER;
        if (isFooter(position)) return TYPE_ITEM_FOOTER;

        Member member = members.get(position);

        if (member.isAvailable()){
            return TYPE_ITEM_YES_VIEW;
        }
        return TYPE_ITEM_NOT_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM_HEADER){
            View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_header,parent, false);
            return new CustomViewHeaderHolder(header);
        }else if (viewType == TYPE_ITEM_YES_VIEW){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_yes,parent,false);
            return new CustomViewYesHolder(view);
        }else if (viewType == TYPE_ITEM_NOT_VIEW){

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_no,parent, false);
            return new CustomViewNoHolder(view);

        }
        View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_footer,parent,false);

        return new CustomViewFooterHolder(footer);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);

        if (holder instanceof CustomViewYesHolder){
            TextView first_name = ((CustomViewYesHolder) holder).first_name;
            TextView last_name = ((CustomViewYesHolder) holder).last_name;

            first_name.setText(member.getFirstName());
            last_name.setText(member.getLastName());
        }

        if (holder instanceof CustomViewNoHolder) {
            TextView firsName = ((CustomViewNoHolder) holder).first_name;
            TextView lastName = ((CustomViewNoHolder) holder).last_name;

            firsName.setText("This firstName is not available");
            lastName.setText("This lastName is not available");
        }
    }




    @Override
    public int getItemCount() {
        return members.size();
    }

    public boolean isHeader(int position){
        return position == 0;
    }

    public boolean isFooter(int position){
        return position == members.size() - 1;
    }


    //Holders

    public static class CustomViewHeaderHolder extends RecyclerView.ViewHolder{
        public View view;
        public CustomViewHeaderHolder( View v) {
            super(v);
            view = v;
        }
    }

    public static class CustomViewYesHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView first_name, last_name;

        public CustomViewYesHolder(View v){
            super(v);
            view = v;

            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);

        }
    }

    public static class CustomViewNoHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView first_name, last_name;

        public CustomViewNoHolder(@NonNull View v) {
            super(v);
            view = v;
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }
    public static class CustomViewFooterHolder extends RecyclerView.ViewHolder{
        public View view;

        public CustomViewFooterHolder(@NonNull View v) {
            super(v);
            view = v;
        }
    }


}
