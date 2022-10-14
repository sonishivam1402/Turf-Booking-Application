package com.example.turfbookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    TextView openSignUp;
    Button btnLogin;
    EditText LoginEmail;
    EditText LoginPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        LoginEmail = findViewById(R.id.LoginEmail);
        openSignUp = findViewById(R.id.openSignUp);
        btnLogin = findViewById(R.id.btnLogin);
        LoginPassword = findViewById(R.id.LoginPassword);

        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
                //startActivity(new Intent(SignIn.this,MainActivity.class));
            }
        });

        openSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this,SignUp.class));
            }
        });
    }
    private void loginUser(){
        String email = LoginEmail.getText().toString();
        String password = LoginPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            LoginEmail.setError("Email cannot be empty");
            LoginEmail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            LoginPassword.setError("Password cannot be empty");
            LoginPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(SignIn.this, "User Logged in Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignIn.this,MainActivity.class));
                    }else{
                        Toast.makeText(SignIn.this, "Log In Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}