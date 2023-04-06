package com.example.metromate;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MapActivity extends AppCompatActivity {
    private Button map_home_button;
    private ScaleGestureDetector scaleGestureDetector;
    private float FACTOR = 1.0f;
    ImageView map_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        map_map = (ImageView) findViewById(R.id.map_map);
        map_home_button = findViewById(R.id.map_home_button);
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListner());

        map_home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class ScaleListner extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            FACTOR *= detector.getScaleFactor();
            FACTOR = Math.max(0.1f, Math.min(FACTOR, 10.f));
            map_map.setScaleX(FACTOR);
            map_map.setScaleY(FACTOR);
            return true;
        }
    }
}