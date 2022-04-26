package com.friendsit.hellorajbari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AboutActivity extends AppCompatActivity {
    private LinearLayout adminLay;
    private Button logInBtn;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private String STATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initial();

        stateCheck();
    }

    private void stateCheck() {
        STATE = sharedPreferences.getString("State","");
        if (STATE == "SignIn"){
            adminLay.setVisibility(View.GONE);
            logInBtn.setVisibility(View.GONE);
            ///////////////////////////////////
        }
    }

    private void initial() {
        adminLay = findViewById(R.id.adminLay);
        logInBtn = findViewById(R.id.logInBtn);
        sharedPreferences = getSharedPreferences("MySp",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("AllData");
    }

    public void logInClick(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(AboutActivity.this).create();
        View dialogView = LayoutInflater.from(AboutActivity.this).inflate(R.layout.login_panel,null);
        TextInputEditText emailEt = alertDialog.findViewById(R.id.emailEt);
        TextInputEditText passwordEt = alertDialog.findViewById(R.id.passwordEt);
        MaterialButton signInBtn = alertDialog.findViewById(R.id.signInBtn);
        alertDialog.setView(dialogView);

        signInBtn.setOnClickListener(view2 -> {
            String emailIn = emailEt.getText().toString().trim();
            String passwordIn = passwordEt.getText().toString().trim();
            if (emailIn.isEmpty() || passwordIn.isEmpty()){
                Toast.makeText(AboutActivity.this,"Invalid Value",Toast.LENGTH_SHORT).show();
            }else{
                firebaseAuth.signInWithEmailAndPassword(emailIn,passwordIn).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            STATE = "SignIn";
                            editor.putString("State","SignIn").commit();
                        }else{
                            Toast.makeText(AboutActivity.this,task.getException().getMessage().toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        alertDialog.show();
    }
}