package com.friendsit.hellorajbari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity {
    private SearchView taskSv;
    private TextView tv;
    private String State;
    private LinearLayout adminLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        initial();

        stateCheck();

        if (State != null && !State.isEmpty()){
            tv.setText(State);
        }

    }

    private void stateCheck() {
        Intent intent = getIntent();
        this.State = intent.getStringExtra("State");
        if (State.equals("au")){
            taskSv.setVisibility(View.GONE);
            adminLay.setVisibility(View.VISIBLE);
            tv.setVisibility(View.GONE);
        }
    }

    private void initial() {
        taskSv = findViewById(R.id.taskSv);
        tv = findViewById(R.id.tv);
        adminLay = findViewById(R.id.adminLay);
    }
}