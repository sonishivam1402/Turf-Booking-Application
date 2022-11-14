package com.example.turfbookingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetPassword extends AppCompatActivity {

    private EditText forgetemail;
    private Button reset_btn;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forgetemail = findViewById(R.id.forgtemail);
        reset_btn = findViewById(R.id.reset_btn);

        auth = FirebaseAuth.getInstance();

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
    }

    private void resetPassword(){
        String email = forgetemail.getText().toString().trim();

        if(email.isEmpty()){
            forgetemail.setError("Email is Required !!");
            forgetemail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            forgetemail.setError("Provide valid email");
            forgetemail.requestFocus();
            return;
        }

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(forgetPassword.this,"Check your email to reset your password",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(forgetPassword.this,"Something went Wrong !! Try Again !!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}