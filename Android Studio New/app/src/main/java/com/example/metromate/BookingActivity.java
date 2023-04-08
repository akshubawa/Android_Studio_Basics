package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    //EditText stations_lines;

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

                Intent intent = new Intent(BookingActivity.this, StationsActivity.class);

                Methods methods = MetroApi.getRetrofitInstance().create(Methods.class);
                Call<Model> call = methods.getAllData();

                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        //Log.e(TAG,"onResponse: Code: "+response.code() );

                        Intent intent = new Intent(BookingActivity.this, StationsActivity.class);
                        intent.putExtra("response_code", response.code());
                        ArrayList<String> line1 = null;
                        intent.putExtra("line1", line1);
                        ArrayList<String> line2 = null;
                        intent.putExtra("line2", line2);
                        ArrayList<String> interchange = null;
                        intent.putExtra("interchange", interchange);
                        ArrayList<String> path = null;
                        intent.putExtra("path", path);
                        String time = null;
                        intent.putExtra("time", time);
                        startActivity(intent);

                        assert response.body() != null;
                        line1 = response.body().getLine1();
                        line2 = response.body().getLine2();
                        interchange = response.body().getInterchange();
                        path = response.body().getPath();
                        time = response.body().getTime();

                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e(TAG, "onFailure "+t.getMessage());

                    }
                });

                // String fromStation = booking_from.getText().toString();
                // String toStation = booking_to.getText().toString();

                //intent.putExtra("booking_from",fromStation);
                //intent.putExtra("booking_to",toStation);

                /*String encodedFromStation = null;
                try {
                    encodedFromStation = URLEncoder.encode(fromStation, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                String encodedToStation = null;
                try {
                    encodedToStation = URLEncoder.encode(toStation, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }*/

                startActivity(intent);
            }
        });
    }
}