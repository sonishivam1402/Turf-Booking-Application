package com.example.turfbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class booking_detail extends AppCompatActivity {

    ImageView img,map_dir;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);

        img=(ImageView)findViewById(R.id.desc_img);
        tv1=(TextView)findViewById(R.id.desc_header);
        tv2=(TextView)findViewById(R.id.desc_desc);
        map_dir = findViewById(R.id.map_dir);

        img.setImageResource(getIntent().getIntExtra("Turf Image",0));
        tv1.setText(getIntent().getStringExtra("Turf Name"));
        tv2.setText(getIntent().getStringExtra("Turf Location"));

        map_dir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(booking_detail.this,MapsActivity.class);
                intent.putExtra("Turf Name",tv1.getText());
                startActivity(intent);
            }
        });

    }
}