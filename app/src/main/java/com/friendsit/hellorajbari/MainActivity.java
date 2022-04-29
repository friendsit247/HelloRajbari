package com.friendsit.hellorajbari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private SearchView homeSv;
    public static DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
    }

    private void initial() {
        homeSv = findViewById(R.id.homeSv);
        databaseReference = FirebaseDatabase.getInstance().getReference("AllData");
        databaseReference.keepSynced(true);
    }

    public void govtOfficeClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","GovtOffice");
        startActivity(intent);
    }

    public void policeClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","Police");
        startActivity(intent);
    }

    public void hospitalClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","Hospital");
        startActivity(intent);
    }

    public void fireServiceClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","FireService");
        startActivity(intent);
    }

    public void ambulanceClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","Ambulance");
        startActivity(intent);
    }

    public void doctorsClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","Doctors");
        startActivity(intent);
    }

    public void bloodDonorsClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","BloodDonors");
        startActivity(intent);
    }

    public void touristSpotClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","TouristSpots");
        startActivity(intent);
    }

    public void hotelsClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","Hotels");
        startActivity(intent);
    }

    public void rentACarClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","RentACar");
        startActivity(intent);
    }

    public void electricityClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("Cat","Electricity");
        startActivity(intent);
    }

    public void aboutUsClick(View view) {
        Intent intent = new Intent(MainActivity.this,TaskActivity.class);
        intent.putExtra("State","About");
        startActivity(intent);
    }
}