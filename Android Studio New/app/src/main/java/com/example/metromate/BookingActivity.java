package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity {
    private static final String TAG = "BookingActivity";

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

                String source = booking_from.getText().toString();
                String destination = booking_to.getText().toString();

                String fromStation = booking_from.getText().toString();
                String toStation = booking_to.getText().toString();

                fromStation.replace(" ","%20");
                toStation.replace(" ","%20");

                Methods methods = MetroApi.getRetrofitInstance(fromStation,toStation).create(Methods.class);
                Call<Model> call = methods.getAllData(fromStation, toStation);

                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        if (response.isSuccessful()) {
                            Model model = response.body();
                            if (model != null) {
                                int status = Integer.parseInt(model.getStatus());
                                if (status == 200) {
                                    Intent intent = new Intent(BookingActivity.this, StationsActivity.class);
                                    intent.putExtra("source", source);
                                    intent.putExtra("destination", destination);

                                    intent.putExtra("Line1", response.body().getLine1());
                                    intent.putExtra("Line2", response.body().getLine2());
                                    intent.putExtra("LineEnds", response.body().getLineEnds());
                                    intent.putExtra("Interchange", response.body().getInterchange());
                                    intent.putExtra("Path", response.body().getPath());
                                    intent.putExtra("Time", response.body().getTime());

                                    assert response.body() != null;
                                    ArrayList<String> line1 = response.body().getLine1();
                                    ArrayList<String> line2 = response.body().getLine2();
                                    ArrayList<String> interchange = response.body().getInterchange();
                                    ArrayList<String> path = response.body().getPath();
                                    String time = response.body().getTime();

                                    int var_time = (int) Math.ceil(Double.parseDouble(time));
                                    int fare = 0;
                                    if (var_time>=55) {
                                        fare=60;
                                    }
                                    else if (var_time>=40) {
                                        fare=50;
                                    }
                                    else if (var_time>=30) {
                                        fare=40;
                                    }
                                    else if (var_time>=20) {
                                        fare=30;
                                    }
                                    else if (var_time>=10) {
                                        fare=20;
                                    }
                                    else if (var_time<=10) {
                                        fare=10;
                                    }
                                    intent.putExtra("fare",fare);

                                    intent.putExtra("source",source);
                                    intent.putExtra("destination",destination);

                                    startActivity(intent);

                                    startActivity(intent);
                                } else if (status == 204) {
                                    Toast.makeText(BookingActivity.this, "Same Source and Destination", Toast.LENGTH_SHORT).show();
                                } else if (status == 400) {
                                    Toast.makeText(BookingActivity.this, "Undefined Source or Destination", Toast.LENGTH_SHORT).show();
                                } else if (status == 4061) {
                                    Toast.makeText(BookingActivity.this, "Invalid Source", Toast.LENGTH_SHORT).show();
                                } else if (status == 4062) {
                                    Toast.makeText(BookingActivity.this, "Invalid Destination", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e(TAG, "onFailure "+t.getMessage());

                    }
                });

            }
        });
    }
}