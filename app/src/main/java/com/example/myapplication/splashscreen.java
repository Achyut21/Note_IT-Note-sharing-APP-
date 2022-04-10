package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class splashscreen extends AppCompatActivity {
    Animation topAnim, bottomAnim;
    ImageView imageView;
     FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        topAnim = AnimationUtils.loadAnimation(this,R.anim.topanim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottomanim);

        imageView = findViewById(R.id.templogo);


        imageView.setAnimation(topAnim);
         mAuth = FirebaseAuth.getInstance();



    }
    @Override
      public void onStart() {
        super.onStart();
    // Check if user is signed in (non-null) and update UI accordingly.
     FirebaseUser currentUser = mAuth.getCurrentUser();
    if(currentUser != null){
      startActivity(new Intent(splashscreen.this,MainActivity.class));
      }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashscreen.this,ws1.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}