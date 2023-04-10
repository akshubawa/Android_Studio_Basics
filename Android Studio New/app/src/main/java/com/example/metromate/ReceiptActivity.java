package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptActivity extends AppCompatActivity {
    private TextView receipt_ticketNumber;
    private TextView receipt_journey;
    private TextView receipt_date;
    private TextView receipt_time;
    private TextView receipt_fare;

    private Button receipt_download;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        receipt_ticketNumber = findViewById(R.id.receipt_ticketNumber);
        receipt_download = findViewById(R.id.receipt_download);

        Intent intent = getIntent();

        int random = intent.getIntExtra("random_number",0);
        String source = intent.getStringExtra("source1");
        String destination = intent.getStringExtra("destination1");
        int fare2 = intent.getIntExtra("fare2",0);

        receipt_date = findViewById(R.id.receipt_date);
        receipt_time = findViewById(R.id.receipt_time);
        receipt_journey = findViewById(R.id.receipt_journey);
        receipt_fare = findViewById(R.id.receipt_fare);

        Date currentDate = (Date) getIntent().getSerializableExtra("currentDate");
        Date currentTime = (Date) getIntent().getSerializableExtra("currentDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String dateString = dateFormat.format(currentDate);
        String timeString = timeFormat.format(currentTime);

        receipt_ticketNumber.setText("Ticket Number: "+random);
        receipt_date.setText("Date: " + dateString);
        receipt_time.setText("Time: "+ timeString);
        receipt_journey.setText("Journey: "+source+" to "+destination);
        receipt_fare.setText("Fare: "+fare2+" Rupees");

        receipt_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent10 = new Intent(ReceiptActivity.this, RouteActivity.class);
                startActivity(intent10);
            }
        });

    }
}