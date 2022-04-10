package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class loginpage extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText regPassword ,regEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        regEmail= findViewById(R.id.semail);
        regPassword=findViewById(R.id.lpassword);
        mAuth = FirebaseAuth.getInstance();
    }
    public void ToSignUpScreen(View view) {
        startActivity(new Intent(loginpage.this,signuppage.class));
    }

    public void Login(View view) {
        loginUser();

    }

    private void loginUser() {
        String email = regEmail.getText().toString();
        String password = regPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            regEmail.setError("Email required");
            regEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)) {
            regPassword.setError("Password Error");
            regPassword.requestFocus();
        }
        else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(loginpage.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginpage.this, MainActivity.class));
                    }else{
                        Toast.makeText(loginpage.this, "Log in Error: " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}