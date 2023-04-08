package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StationsActivity extends AppCompatActivity {

    private Button stations_back_button;
    private String from_station;
    private String to_station;
    private TextView stations_line1;
    private TextView stations_line2;
    private TextView stations_mainStations;
    private TextView stations_lineEnds;
    private TextView stations_path;
    private TextView stations_time;
    private Button stations_proceed_button;

    @SuppressLint("SetText")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);

        Intent intent = getIntent();
        String responseCode = getIntent().getStringExtra("responseCode");
        ArrayList<String> line1 = getIntent().getStringArrayListExtra("line1");
        ArrayList<String> line2 = getIntent().getStringArrayListExtra("line2");
        ArrayList<String> interchange = getIntent().getStringArrayListExtra("interchange");
        ArrayList<String> path = getIntent().getStringArrayListExtra("path");
        String time = getIntent().getStringExtra("time");

        Model model = new Model();
        model.setLine1(line1);
        model.setLine2(line2);
        model.setInterchange(interchange);
        model.setPath(path);
        model.setTime(time);

        stations_line1 = findViewById(R.id.stations_line1);
        stations_line2 = findViewById(R.id.stations_line2);
        stations_mainStations = findViewById(R.id.stations_mainStations);
        stations_lineEnds = findViewById(R.id.stations_lineEnds);
        stations_path = findViewById(R.id.stations_path);
        stations_time = findViewById(R.id.stations_time);

        if (responseCode == String.valueOf(200)) {
            stations_line1.setText("Line1: " + model.getLine1().toString());
            stations_line2.setText("Line2: " + model.getLine2().toString());
            stations_mainStations.setText("Interchange: " + model.getInterchange().toString());
            stations_lineEnds.setText("Line ends: " + model.getLineEnds().toString());
            stations_path.setText("Path: " + model.getPath().toString());
            stations_time.setText("Time: " + model.getTime());
        }

        stations_proceed_button = findViewById(R.id.stations_proceed_button);
        stations_proceed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StationsActivity.this, ReceiptActivity.class);
                startActivity(intent);
            }
        });

        stations_back_button = findViewById(R.id.stations_back_button);
        stations_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StationsActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });
    }
}
