package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
    Button dashboard_booking_button;
    Button dashboard_signup_button;
    Button dashboard_login_button;
    Button dashboard_map_button;
    Button dashboard_wallet_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        dashboard_booking_button = findViewById(R.id.dashboard_booking_button);
        dashboard_booking_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });

        dashboard_signup_button = findViewById(R.id.dashboard_signup_button);
        dashboard_signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        dashboard_login_button = findViewById(R.id.dashboard_login_button);
        dashboard_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        dashboard_map_button = findViewById(R.id.dashboard_map_button);
        dashboard_map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        dashboard_wallet_button = findViewById(R.id.dashboard_wallet_button);
        dashboard_wallet_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, WalletActivity.class);
                startActivity(intent);
            }
        });

    }
}