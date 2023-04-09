package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class StationsActivity extends AppCompatActivity {

    private Button stations_back_button;
    private TextView stations_line1;
    private TextView stations_line2;
    private TextView stations_mainStations;
    private TextView stations_lineEnds;
    private TextView stations_path;
    private TextView stations_time;
    private TextView stations_fare;
    private Button stations_proceed_button;

    private int randomNum;

    @SuppressLint({"SetText", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);

        stations_line1 = findViewById(R.id.stations_line1);
        stations_line2 = findViewById(R.id.stations_line2);
        stations_mainStations = findViewById(R.id.stations_mainStations);
        stations_lineEnds = findViewById(R.id.stations_lineEnds);
        stations_path = findViewById(R.id.stations_path);
        stations_time = findViewById(R.id.stations_time);
        stations_fare = findViewById(R.id.stations_fare);

        Intent intent = getIntent();

        int responseCode = intent.getIntExtra("responseCode", -1);
        String source = intent.getStringExtra("source");
        String destination = intent.getStringExtra("destination");

        ArrayList<String> line1 = intent.getStringArrayListExtra("Line1");
        ArrayList<String> line2 = intent.getStringArrayListExtra("Line2");
        ArrayList<String> interchange = intent.getStringArrayListExtra("Interchange");
        ArrayList<String> lineEnds = intent.getStringArrayListExtra("LineEnds");
        ArrayList<String> path = intent.getStringArrayListExtra("Path");
        String time = intent.getStringExtra("Time");
        int fare = intent.getIntExtra("fare",0);
        int final_time = (int) Math.ceil(Double.parseDouble(time));


        stations_line1.setText("Line1: " + line1);
        stations_line2.setText("line2: " + line2);
        stations_mainStations.setText("Interchange: " + interchange);
        stations_lineEnds.setText("Line Ends: " + lineEnds);
        stations_path.setText("Path: " + path);
        stations_time.setText("Time: " + final_time + " Minutes");
        stations_fare.setText("Fare: " + fare + " Rupees");


        stations_proceed_button = findViewById(R.id.stations_proceed_button);
        stations_proceed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StationsActivity.this, ReceiptActivity.class);

                intent.putExtra("fare2",fare);
                intent.putExtra("source1",source);
                intent.putExtra("destination1",destination);

                Random rand = new Random();
                int randomNum = rand.nextInt(90000000)+10000000;
                intent.putExtra("random_number",randomNum);

                Date currentDate = new Date();
                intent.putExtra("currentDate",currentDate);

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
