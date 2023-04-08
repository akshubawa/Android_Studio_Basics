package com.example.metromate;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jsibbold.zoomage.ZoomageView;

public class MapActivity extends AppCompatActivity {

    ImageView map_image;
    private Button map_home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        map_image = findViewById(R.id.map_image);
        map_home_button = findViewById(R.id.map_home_button);
        map_home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}