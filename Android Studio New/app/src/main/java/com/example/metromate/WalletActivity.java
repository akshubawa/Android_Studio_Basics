package com.example.metromate;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WalletActivity extends AppCompatActivity {
    private TextView wallet_textview;
    private Button wallet_add_button;
    private int balance = 0;

    private Button wallet_home_button;
    private static final int REQUEST_CODE_ADD_MONEY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        wallet_textview = findViewById(R.id.wallet_textview);
        wallet_add_button = findViewById(R.id.wallet_add_button);
        wallet_home_button = findViewById(R.id.wallet_home_button);

        updateWalletBalance();

        wallet_home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WalletActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

        wallet_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalletActivity.this, AddMoneyActivity.class);
                intent.putExtra("BALANCE", balance);
                startActivityForResult(intent, REQUEST_CODE_ADD_MONEY);
            }
        });
    }
    private void updateWalletBalance() {
        wallet_textview.setText(balance + " Rupees");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD_MONEY && resultCode == RESULT_OK) {
            balance = data.getIntExtra("BALANCE", 0);
            wallet_textview.setText("Balance: " + balance);
            updateWalletBalance();
        }
    }
}