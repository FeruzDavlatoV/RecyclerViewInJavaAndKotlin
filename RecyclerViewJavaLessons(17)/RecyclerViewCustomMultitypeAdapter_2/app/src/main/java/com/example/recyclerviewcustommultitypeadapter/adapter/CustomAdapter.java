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

    private final int TYPE_AVAILABLE_YES = 1;
    private final int TYPE_AVAILABLE_NO = 0;

    private Context context;
    private final List<Member> members;

    public CustomAdapter(Context context,List<com.example.recyclerviewcustommultitypeadapter.Member.Member> members){
        this.context = context;
        this.members = members;
    }


    @Override
    public int getItemViewType(int position) {
        com.example.recyclerviewcustommultitypeadapter.Member.Member member = members.get(position);

        if (member.isAvailable()){
            return TYPE_AVAILABLE_YES;
        }
        return TYPE_AVAILABLE_NO;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_AVAILABLE_YES){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_yes,parent, false);
            return new CustomViewYesHolder(view);
        }
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout_no,parent, false);

            return new CustomViewNoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        com.example.recyclerviewcustommultitypeadapter.Member.Member member = members.get(position);

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


    //Holders

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


}
