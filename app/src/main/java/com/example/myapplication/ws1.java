package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ws1 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws1);
    }

    public void continue_email(View view) {
        Intent intent = new Intent(ws1.this,MainActivity.class);
        startActivity(intent);
    }

    public void loginpage(View view) {
        Intent intent = new Intent(ws1.this,MainActivity.class);
        startActivity(intent);
    }

}