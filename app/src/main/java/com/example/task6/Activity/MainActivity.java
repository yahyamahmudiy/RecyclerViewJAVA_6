package com.example.task6.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Bundle;
import com.example.task6.Adapter.RecyclerAdapter;
import com.example.task6.Model.Member;
import com.example.task6.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Context context;
    NestedScrollView nestedScrollView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews(){
        context = this;
        nestedScrollView = findViewById(R.id.nestedScrollView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
        recyclerView.setNestedScrollingEnabled(false);

        ArrayList<Member> members = new ArrayList<>();

        members.add(new Member());
        for (int i=0;i<=30;i++){
            if(i == 1 ||i == 10) {
                members.add(new Member(R.mipmap.ic_profile, "Yahya " + i, "Mahmudiy " + i));
            }else {
                members.add(new Member(R.mipmap.ic_profile, "Yahya " + i, "Mahmudiy " + i));
            }
        }
        members.add(new Member());

        refreshAdapter(members);
    }

    void refreshAdapter(ArrayList<Member> members){
        RecyclerAdapter adapter = new RecyclerAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }
}