package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {
    FirebaseAuth auth;
    Button dashboard_logout;
    FirebaseUser user;
    Button dashboard_booking_button;
    Button dashboard_map_button;
    Button dashboard_wallet_button;
    TextView dashboard_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        dashboard_logout = findViewById(R.id.dashboard_logout_button);
        dashboard_name=findViewById(R.id.dashboard_name);

        if (user==null) {
            Intent intent = new Intent(getApplicationContext(), FirstPageActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            dashboard_name.setText("Welcome "+user.getDisplayName());
        }

        dashboard_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), FirstPageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        dashboard_booking_button = findViewById(R.id.dashboard_booking_button);
        dashboard_booking_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, BookingActivity.class);
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