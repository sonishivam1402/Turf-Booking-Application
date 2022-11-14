package com.example.turfbookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView TurfRV = findViewById(R.id.RVTurf);

        // Here, we have created new array list and added data to it
        ArrayList<TurfModel> courseModelArrayList = new ArrayList<TurfModel>();
        courseModelArrayList.add(new TurfModel("Hattrick","Chhani", R.drawable.hattrick_chhani, 4.5F, "RS 1100/Hour"));
        courseModelArrayList.add(new TurfModel("Turf 106", "Sevasi", R.drawable.turf_sevasi, 4.5F, "RS 1200/Hour"));
        courseModelArrayList.add(new TurfModel("The Eclipse Sports", "New Alkapuri", R.drawable.eclipse_sports_alkapuri, 4.8f, "RS 1000/Hour"));
        courseModelArrayList.add(new TurfModel("Delta 9", "Gorwa", R.drawable.delta_gorwa, 4.6F, "RS 900/Hour"));
        courseModelArrayList.add(new TurfModel("Huddle Arena", "Vasna Bhayli", R.drawable.huddle_arena_vasna, 4.9f, "RS 1150/Hour"));
        courseModelArrayList.add(new TurfModel("Gameplex Arena", "Subhanpura", R.drawable.gameplex_arena_subhanpura, 4.4f, "RS 950/Hour"));
        courseModelArrayList.add(new TurfModel("Super Sports Park", "Gorwa", R.drawable.super_sports_park_gorwa, 4.4f, "RS 1250/Hour"));

        // we are initializing our adapter class and passing our arraylist to it.
        TurfAdapter courseAdapter = new TurfAdapter(this, courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        TurfRV.setLayoutManager(linearLayoutManager);
        TurfRV.setAdapter(courseAdapter);
    }
}