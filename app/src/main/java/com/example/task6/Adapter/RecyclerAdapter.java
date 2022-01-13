package com.example.task6.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.task6.Model.Member;
import com.example.task6.R;
import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_LIST = 1;

    Context context;
    ArrayList<Member> members;

    public RecyclerAdapter(Context context, ArrayList<Member> members){
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        Member member = members.get(position);
        if(member == null) return TYPE_ITEM_LIST;

        return TYPE_ITEM_VIEW;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == TYPE_ITEM_LIST){
            View header = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
            return new MemberListHolder(header);
        }

        View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_view, parent, false);
        return new MemberViewHolder(footer);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);

        if(holder instanceof MemberViewHolder){

        }
        if(holder instanceof MemberListHolder){
            RecyclerView recyclerView = ((MemberListHolder)holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));

        }
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {
        public View view;
        RecyclerView recyclerView;

        public MemberViewHolder(View v) {
            super(v);
            this.view = v;

        }
    }

    public class MemberListHolder extends RecyclerView.ViewHolder{
        public View view;
        RecyclerView recyclerView;

        public MemberListHolder(View v){
            super(v);
            this.view = v;

            recyclerView = view.findViewById(R.id.recyclerView);
        }
    }


}

