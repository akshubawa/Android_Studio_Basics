package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstPageActivity extends AppCompatActivity {

    private Button firstPage_signup_button;
    private Button firstPage_login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        firstPage_signup_button = findViewById(R.id.firstPage_signup_button);
        firstPage_signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPageActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        firstPage_login_button = findViewById(R.id.firstPage_login_button);
        firstPage_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstPageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}