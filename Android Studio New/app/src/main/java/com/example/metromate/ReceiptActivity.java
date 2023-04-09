package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiptActivity extends AppCompatActivity {

    private TextView receipt_ticketNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        receipt_ticketNumber = findViewById(R.id.receipt_ticketNumber);

        Intent intent = getIntent();
        int random = getIntent().getIntExtra("random_number",0);
        receipt_ticketNumber.setText("Ticket Number: "+random);

    }
}