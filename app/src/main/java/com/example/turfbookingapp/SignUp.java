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
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {

    TextView AlreadyHaveAcc;
    Button btnSignup;
    EditText ResEmail,ResName;
    EditText ResPassword;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSignup = findViewById(R.id.btnSignup);
        AlreadyHaveAcc = findViewById(R.id.AlreadyHaveAcc);
        ResEmail = findViewById(R.id.ResEmail);
        ResPassword = findViewById(R.id.ResPassword);
        ResName = findViewById(R.id.ResName);
        mAuth = FirebaseAuth.getInstance();


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object> m = new HashMap<String,Object>();
                m.put("Name",ResName.getText().toString());
                m.put("Email",ResEmail.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Users").push().setValue(m);
                createUser();
//                startActivity(new Intent(SignUp.this,SignIn.class));
            }
        });

        AlreadyHaveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this,SignIn.class));
            }
        });
    }
    private void createUser(){
        String email = ResEmail.getText().toString();
        String password = ResPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            ResEmail.setError("Email cannot be empty");
            ResEmail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            ResPassword.setError("Password cannot be empty");
            ResPassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(SignUp.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUp.this,SignIn.class));
                    }else{
                        Toast.makeText(SignUp.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}