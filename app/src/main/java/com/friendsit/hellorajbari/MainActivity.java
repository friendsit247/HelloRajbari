package com.friendsit.hellorajbari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SearchView homeSv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
    }

    private void initial() {
        homeSv = findViewById(R.id.homeSv);

    }

    public void govtOfficeClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","go");
        startActivity(intent);
    }

    public void policeClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","po");
        startActivity(intent);
    }

    public void hospitalClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","ho");
        startActivity(intent);
    }

    public void fireServiceClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","fs");
        startActivity(intent);
    }

    public void ambulanceClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","am");
        startActivity(intent);
    }

    public void doctorsClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","do");
        startActivity(intent);
    }

    public void bloodDonorsClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","bd");
        startActivity(intent);
    }

    public void touristSpotClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","ts");
        startActivity(intent);
    }

    public void hotelsClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","ht");
        startActivity(intent);
    }

    public void rentACarClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","rc");
        startActivity(intent);
    }

    public void electricityClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","ec");
        startActivity(intent);
    }

    public void aboutUsClick(View view) {
        startActivity(new Intent(MainActivity.this,AboutActivity.class));
    }
}