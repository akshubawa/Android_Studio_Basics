package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    ArrayList<CardModel> arrCard = new ArrayList<CardModel>();
    RecyclerView route_recycler;

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

        route_recycler = findViewById(R.id.route_recycler);

       /* stations_line1 = findViewById(R.id.stations_line1);
        stations_line2 = findViewById(R.id.stations_line2);
        stations_mainStations = findViewById(R.id.stations_mainStations);
        stations_lineEnds = findViewById(R.id.stations_lineEnds);
        stations_path = findViewById(R.id.stations_path);
        stations_time = findViewById(R.id.stations_time);
        stations_fare = findViewById(R.id.stations_fare);*/

        route_recycler.setLayoutManager(new LinearLayoutManager(StationsActivity.this));

        CardModel model = new CardModel("Akshardham","Blue Line");
        arrCard.add(new CardModel("Tilak Nagar","Blue"));
        arrCard.add(new CardModel("Moti Nagar","Blue"));
        arrCard.add(new CardModel("Ashok Park","Green"));
        arrCard.add(new CardModel("Inderlok","Green"));
        arrCard.add(new CardModel("Shashtri Nagar","Red"));
        arrCard.add(new CardModel("Pratap Nagar","Red"));
        arrCard.add(new CardModel("Pul Bangash","Red"));
        arrCard.add(new CardModel("Kashmere Gate","Red"));
        arrCard.add(new CardModel("Jafrabad","Pink"));
        arrCard.add(new CardModel("Gokulpuri","Pink"));
        arrCard.add(new CardModel("Maujpur","Pink"));
        arrCard.add(new CardModel("Lal Quila","Violet"));
        arrCard.add(new CardModel("Delhi Gate","Violet"));
        arrCard.add(new CardModel("ITO","Violet"));
        arrCard.add(new CardModel("Mandi House","Violet"));
        arrCard.add(new CardModel("Jama Masjid","Violet"));
        arrCard.add(new CardModel("Noida Sector 52","Blue"));

        RecyclerCardAdapter adapter = new RecyclerCardAdapter(StationsActivity.this, arrCard);
        route_recycler.setAdapter(adapter);

        Intent intent = getIntent();

        int responseCode = intent.getIntExtra("responseCode", -1);
        String source = intent.getStringExtra("source");
        String destination = intent.getStringExtra("destination");

        String[] sources = source.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word: sources) {
            sb.append(Character.toUpperCase(word.charAt(0)) + word.substring(1));
            sb.append(" ");
        }
        String final_source = sb.toString().trim();

        String[] destinations = destination.split(" ");
        StringBuilder sb2 = new StringBuilder();
        for (String word: destinations) {
            sb2.append(Character.toUpperCase(word.charAt(0)) + word.substring(1));
            sb2.append(" ");
        }
        String final_destination = sb2.toString().trim();

        ArrayList<String> line1 = intent.getStringArrayListExtra("Line1");
        ArrayList<String> line2 = intent.getStringArrayListExtra("Line2");
        ArrayList<String> interchange = intent.getStringArrayListExtra("Interchange");
        ArrayList<String> lineEnds = intent.getStringArrayListExtra("LineEnds");
        ArrayList<String> path = intent.getStringArrayListExtra("Path");
        String time = intent.getStringExtra("Time");
        int fare = intent.getIntExtra("fare",0);
        int final_time = (int) Math.ceil(Double.parseDouble(time));


       /* stations_line1.setText("Line1: " + line1);
        stations_line2.setText("line2: " + line2);
        stations_mainStations.setText("Interchange: " + interchange);
        stations_lineEnds.setText("Line Ends: " + lineEnds);
        stations_path.setText("Path: " + path);
        stations_time.setText("Time: " + final_time + " Minutes");
        stations_fare.setText("Fare: " + fare + " Rupees");*/


        stations_proceed_button = findViewById(R.id.stations_proceed_button);
        stations_proceed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StationsActivity.this, ReceiptActivity.class);

                intent.putExtra("fare2",fare);
                intent.putExtra("source1",final_source);
                intent.putExtra("destination1",final_destination);

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
