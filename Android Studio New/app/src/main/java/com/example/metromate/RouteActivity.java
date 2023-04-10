package com.example.metromate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RouteActivity extends AppCompatActivity {
    ArrayList<CardModel> arrCard = new ArrayList<CardModel>();
    RecyclerView route_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        route_recycler = findViewById(R.id.route_recycler);

        route_recycler.setLayoutManager(new LinearLayoutManager(RouteActivity.this));

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

        RecyclerCardAdapter adapter = new RecyclerCardAdapter(RouteActivity.this, arrCard);
        route_recycler.setAdapter(adapter);

    }
}