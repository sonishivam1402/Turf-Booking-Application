package com.example.turfbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class booking_detail extends AppCompatActivity {

    ImageView img,map_dir;
    TextView tv1,tv2, tvBill;
    Button slot1, slot2, slot3, slot4, slot5, slot6, btnBill;
    private int totalBill, totalSlots;
    private boolean click1, click2, click3, click4, click5, click6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);

        img=(ImageView)findViewById(R.id.desc_img);
        tv1=(TextView)findViewById(R.id.desc_header);
        tv2=(TextView)findViewById(R.id.desc_desc);
        map_dir = findViewById(R.id.map_dir);
        slot1 = findViewById(R.id.slot1);
        slot2 = findViewById(R.id.slot2);
        slot3 = findViewById(R.id.slot3);
        slot4 = findViewById(R.id.slot4);
        slot5 = findViewById(R.id.slot5);
        slot6 = findViewById(R.id.slot6);
        tvBill = findViewById(R.id.tvBill);
        btnBill = findViewById(R.id.btnBill);

        totalBill = 0;
        totalSlots = 0;
        click1 = false;
        click2 = false;
        click3 = false;
        click4 = false;
        click5 = false;
        click6 = false;

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

        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!click1) {
                    totalBill += 1500;
                    totalSlots++;
                    slot1.setBackgroundColor(getResources().getColor(R.color.clicked));
                    click1 = true;
                } else {
                    totalBill -= 1500;
                    totalSlots--;
                    click1 = false;
                    slot1.setBackgroundColor(Color.parseColor("#D3D3D3"));
                }
            }
        });

        slot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!click2) {
                    totalBill += 1500;
                    totalSlots++;
                    slot2.setBackgroundColor(getResources().getColor(R.color.clicked));
                    click2 = true;
                } else {
                    totalBill -= 1500;
                    totalSlots--;
                    click2 = false;
                    slot2.setBackgroundColor(Color.parseColor("#D3D3D3"));
                }
            }
        });

        slot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!click3) {
                    totalBill += 1500;
                    totalSlots++;
                    slot3.setBackgroundColor(getResources().getColor(R.color.clicked));
                    click3 = true;
                } else {
                    totalBill -= 1500;
                    totalSlots--;
                    click3 = false;
                    slot3.setBackgroundColor(Color.parseColor("#D3D3D3"));
                }
            }
        });

        slot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!click4) {
                    totalBill += 1500;
                    totalSlots++;
                    slot4.setBackgroundColor(getResources().getColor(R.color.clicked));
                    click4 = true;
                } else {
                    totalBill -= 1500;
                    totalSlots--;
                    click4 = false;
                    slot4.setBackgroundColor(Color.parseColor("#D3D3D3"));
                }
            }
        });

        slot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!click5) {
                    totalBill += 1500;
                    totalSlots++;
                    slot5.setBackgroundColor(getResources().getColor(R.color.clicked));
                    click5 = true;
                } else {
                    totalBill -= 1500;
                    totalSlots--;
                    click5 = false;
                    slot5.setBackgroundColor(Color.parseColor("#D3D3D3"));
                }
            }
        });

        slot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!click6) {
                    totalBill += 1500;
                    totalSlots++;
                    slot6.setBackgroundColor(getResources().getColor(R.color.clicked));
                    click6 = true;
                } else {
                    totalBill -= 1500;
                    totalSlots--;
                    click6 = false;
                    slot6.setBackgroundColor(Color.parseColor("#D3D3D3"));
                }
            }
        });

        btnBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = "\t\tTotal Bill";

                if(click1) {
                    tmp += "\n\n - Slot 1 (6 - 7 AM) added";
                }

                if(click2) {
                    tmp += "\n\n - Slot 2 (7 - 8 AM) added";
                }

                if(click3) {
                    tmp += "\n\n - Slot 3 (4 - 5 PM) added";
                }

                if(click4) {
                    tmp += "\n\n - Slot 4 (5 - 6 PM) added";
                }

                if(click5) {
                    tmp += "\n\n - Slot 5 (6 - 7 PM) added";
                }

                if(click6) {
                    tmp += "\n\n - Slot 6 (7 - 8 PM) added";
                }

                tmp += "\n\n Total Slots booked = " + totalSlots;
                tmp += "\n Total Cost = Rs " + totalBill;

                tvBill.setText(tmp);
            }
        });
    }
}