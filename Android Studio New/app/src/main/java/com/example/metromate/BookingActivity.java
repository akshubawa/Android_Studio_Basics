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

    //TextView stations_line1;

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

                fromStation.replace(" ","%20");
                toStation.replace(" ","%20");

                //Log.e(TAG, "from: ",fromStation);
                //Log.e(TAG, "to: ",toStation );


                /*String encodedFrom = null;
                try {
                    encodedFrom = URLEncoder.encode(booking_from.getText().toString(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                Log.e(TAG, "Encoded From Station: " + encodedFrom);

                String encodedTo = null;
                try {
                    encodedTo = URLEncoder.encode(booking_to.getText().toString(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
                Log.e(TAG, "Encoded To Station: " + encodedTo);*/

                //intent.putExtra("encodedFrom",encodedFrom);
                //intent.putExtra("encodedTo",encodedTo);

               /* String encodedFrom = Uri.encode(fromStation, "UTF-8");
                String encodedTo = Uri.encode(toStation, "UTF-8");

                Log.e(TAG, "Encoded From Station: " + encodedFrom);
                Log.e(TAG, "Encoded To Station: " + encodedTo);*/

                Methods methods = MetroApi.getRetrofitInstance(fromStation,toStation).create(Methods.class);
                Call<Model> call = methods.getAllData(fromStation, toStation);

                Intent intent = new Intent(BookingActivity.this, StationsActivity.class);

                intent.putExtra("booking_from",fromStation);
                intent.putExtra("booking_to",toStation);

                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Log.e(TAG,"onResponse: Code: "+response.code() );
                        Log.e(TAG,"onResponse: path: "+response.body().getPath() );

                        intent.putExtra("responseCode", response.code());
                        //assert response.body() != null;
                        intent.putExtra("Line1", response.body().getLine1());
                        intent.putExtra("Line2", response.body().getLine2());
                        intent.putExtra("LineEnds", response.body().getLineEnds());
                        intent.putExtra("Interchange", response.body().getInterchange());
                        intent.putExtra("Path", response.body().getPath());
                        intent.putExtra("Time", response.body().getTime());

                        assert response.body() != null;
                        String responseCode = String.valueOf(response.code());
                        ArrayList<String> line1 = response.body().getLine1();
                        ArrayList<String> line2 = response.body().getLine2();
                        ArrayList<String> interchange = response.body().getInterchange();
                        ArrayList<String> path = response.body().getPath();
                        String time = response.body().getTime();

                        startActivity(intent);
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