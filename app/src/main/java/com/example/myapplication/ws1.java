package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ws1 extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws1);
        mAuth = FirebaseAuth.getInstance();
    }

    public void ToLoginScreen(View view) {
        startActivity(new Intent(ws1.this,loginpage.class));
    }

    public void ToSignUpScreen(View view) {
        startActivity(new Intent(ws1.this,signuppage.class));
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            startActivity(new Intent(ws1.this,MainActivity.class));
        }
    }
}