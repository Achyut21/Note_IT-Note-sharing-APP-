package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.media.MediaPlayer;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

public class badgesplash extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView imageView;
    TextView info,date;
    //  FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen);
        topAnim = AnimationUtils.loadAnimation(this,R.anim.topanim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottomanim);

        imageView = findViewById(R.id.badgestat);

        info = findViewById(R.id.badgeinfo);
        date = findViewById(R.id.badgedate);

        imageView.setAnimation(topAnim);
        date.setAnimation(bottomAnim);
        info.setAnimation(bottomAnim);

        // mAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MediaPlayer ring= MediaPlayer.create(badgesplash.this,R.raw.ring);
                ring.start();
                Intent intent = new Intent(badgesplash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);

    }

}