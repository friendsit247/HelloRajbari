package com.friendsit.hellorajbari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {
    private SearchView taskSv;
    private String State;
    private LinearLayout adminLay,msgLay;
    private String Cat;
    private List<HelloModel> list;
    private RecyclerView recycler;
    private HelloAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        initial();

        stateCheck();

        if (Cat!=null && !Cat.isEmpty()){
            retriveAndShow();
        }
    }

    private void retriveAndShow() {
        DatabaseReference dataRef = MainActivity.databaseReference.child(Cat);
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    msgLay.setVisibility(View.GONE);
                    recycler.setVisibility(View.VISIBLE);
                    list.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        if (dataSnapshot.exists()){
                            HelloModel helloModel = dataSnapshot.getValue(HelloModel.class);
                            list.add(helloModel);
                        }
                    }
                    adapter = new HelloAdapter(TaskActivity.this,list);
                    recycler.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }else{
                    recycler.setVisibility(View.GONE);
                    msgLay.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });

    }

    private void stateCheck() {
        Intent intent = getIntent();
        this.State = intent.getStringExtra("State");
        if (State!=null && !State.isEmpty()){
            if (State.equals("About")){
                taskSv.setVisibility(View.GONE);
                msgLay.setVisibility(View.GONE);
                adminLay.setVisibility(View.VISIBLE);
            }
        }else{
            this.Cat = intent.getStringExtra("Cat");
        }
    }

    private void initial() {
        taskSv = findViewById(R.id.taskSv);
        adminLay = findViewById(R.id.adminLay);
        list = new ArrayList<>();
        recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(TaskActivity.this));
        msgLay = findViewById(R.id.msgLay);
    }
}