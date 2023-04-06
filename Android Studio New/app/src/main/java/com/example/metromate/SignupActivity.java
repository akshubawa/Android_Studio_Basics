package com.example.metromate;

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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button signup_button;
    EditText signup_name, signup_email, signup_phone, signup_password, signup_confirm_password;
    TextView loginRedirectText;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseApp.initializeApp(this);

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Toast.makeText(this, "User Already Exists!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        signup_name = findViewById(R.id.signup_name);
        signup_email = findViewById(R.id.signup_email);
        signup_phone = findViewById(R.id.signup_phone);
        signup_password = findViewById(R.id.signup_password);
        signup_confirm_password = findViewById(R.id.signup_confirm_password);

        signup_button = findViewById(R.id.signup_button);

        loginRedirectText = findViewById(R.id.loginRedirectText);
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,email,phone,password,confirm_password;
                name = String.valueOf(signup_name.getText());
                email = String.valueOf(signup_email.getText());
                phone = String.valueOf(signup_phone.getText());
                password = String.valueOf(signup_password.getText());
                confirm_password = String.valueOf(signup_confirm_password.getText());

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(SignupActivity.this, "Please Provide Name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(SignupActivity.this, "Please Provide Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(SignupActivity.this, "Please Provide Mobile Number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(SignupActivity.this, "Please Provide Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(confirm_password)) {
                    Toast.makeText(SignupActivity.this, "Please Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Successfully Registered.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Toast.makeText(SignupActivity.this, "Authentication Failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
            }
        }