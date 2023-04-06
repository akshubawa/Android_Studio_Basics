package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BookingActivity extends AppCompatActivity {
    private Button booking_findRoute_button;
    private EditText booking_from;
    private EditText booking_to;

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
                String from_station = booking_from.getText().toString();
                try {
                    String encodedFromStation = URLEncoder.encode(from_station, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }

                String to_station = booking_to.getText().toString();
                try {
                    String encodedToStation = URLEncoder.encode(to_station, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }

                Intent intent = new Intent(BookingActivity.this, StationsActivity.class);
                intent.putExtra("booking_from",from_station);
                intent.putExtra("booking_to",to_station);
                startActivity(intent);
            }
        });
    }
}