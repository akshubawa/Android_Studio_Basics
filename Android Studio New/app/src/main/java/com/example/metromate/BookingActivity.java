package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BookingActivity extends AppCompatActivity {

    private Button booking_findRoute_button;
    EditText booking_from;
    EditText booking_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        booking_from = findViewById(R.id.booking_from);
        booking_to = findViewById(R.id.booking_to);
        booking_findRoute_button = findViewById(R.id.booking_findRoute_button);
        booking_findRoute_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromStation = booking_from.getText().toString();
                String toStation = booking_to.getText().toString();
                Intent intent = new Intent(BookingActivity.this, StationsActivity.class);
                intent.putExtra("booking_from",fromStation);
                intent.putExtra("booking_to",toStation);
                startActivity(intent);
            }
        });
    }
}