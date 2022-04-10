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

public class signuppage extends AppCompatActivity {
    EditText regName , regPassword ,regEmail;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);
        regName = findViewById(R.id.susername);
        regEmail = findViewById(R.id.semail);
        regPassword = findViewById(R.id.spass);
        mAuth = FirebaseAuth.getInstance();

    }

    public void ToLoginScreen(View view) {
    startActivity(new Intent(signuppage.this,loginpage.class));
    }

    public void Signup(View view) {
        createUser();
    }

    private void createUser() {
        String email = regEmail.getText().toString();
        String password = regPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            regEmail.setError("Email required");
            regEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            regPassword.setError("Password Error");
            regPassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(signuppage.this, "User registered in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signuppage.this, MainActivity.class));
                    }else{
                        Toast.makeText(signuppage.this, "Registration Error " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}