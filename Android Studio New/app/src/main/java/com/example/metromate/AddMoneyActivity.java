package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class AddMoneyActivity extends AppCompatActivity {
    private EditText addMoney_amount;
    private Button addMoney_home_button;
    private Button addMoney_proceed_button;
    private int balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);

        addMoney_amount = findViewById(R.id.addMoney_amount);
        addMoney_home_button = findViewById(R.id.addMoney_home_button);
        addMoney_proceed_button = findViewById(R.id.addMoney_proceed_button);

        balance = getIntent().getIntExtra("BALANCE", 0);

        addMoney_proceed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = addMoney_amount.getText().toString().trim();

                if (!amount.isEmpty()) {
                    int addAmount = Integer.parseInt(amount);
                    balance += addAmount;
                    Intent intent = new Intent();
                    intent.putExtra("BALANCE", balance);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
        addMoney_home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddMoneyActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}