package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StationsActivity extends AppCompatActivity {

    private Button stations_back_button;
    private String from_station;
    private String to_station;
    private TextView stations_lines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);

        Intent intent = getIntent();
        from_station = intent.getStringExtra("booking_from");
        to_station = intent.getStringExtra("booking_to");

        String encodedFromStation;
        try {
            encodedFromStation = URLEncoder.encode(from_station, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String encodedToStation;
        try {
            encodedToStation = URLEncoder.encode(to_station, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        stations_back_button = findViewById(R.id.stations_back_button);
        stations_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StationsActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });

        //String url = "https://us-central1-delhimetroapi.cloudfunctions.net/route-get?from=Dwarka&to=Palam";
        String url = "https://us-central1-delhimetroapi.cloudfunctions.net/route-get?from=" + encodedFromStation + "&to=" + encodedToStation;

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            int statusCode = response.getJSONObject(0).getInt("status");
                            stations_lines = findViewById(R.id.stations_lines);
                            stations_lines.setText("Response Status: " + statusCode);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("StationsActivity", "Something went wrong");
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);
    }
}
