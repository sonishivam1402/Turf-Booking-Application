package com.example.turfbookingapp;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class TurfAdapter extends RecyclerView.Adapter<TurfAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<TurfModel> courseModelArrayList;

    // Constructor
    public TurfAdapter(Context context, ArrayList<TurfModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public TurfAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TurfAdapter.ViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        TurfModel model = courseModelArrayList.get(position);
        holder.TurfNameTV.setText(model.getTurf_name());
        holder.TurfAreaTV.setText(model.getTurf_area());
        holder.TurfIV.setImageResource(model.getTurf_img());
        holder.TurfRating.setRating(model.getTurf_rating());
        holder.TurfPrice.setText(model.getTurf_price());

        holder.TurfPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,booking_detail.class);
                intent.putExtra("Turf Image",model.getTurf_img());
                intent.putExtra("Turf Name",model.getTurf_name());
                intent.putExtra("Turf Location",model.getTurf_area());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                HashMap<String,Object> b = new HashMap<String,Object>();
                b.put("Turf Name",holder.TurfNameTV.getText().toString());
                b.put("Turf Area", holder.TurfAreaTV.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Users").child("Bookings").push().setValue(b);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return courseModelArrayList.size();
    }

    // View holder class for initializing of your views such as TextView and Imageview
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView TurfIV;
        private final TextView TurfNameTV;
        private final TextView TurfAreaTV;
        private final RatingBar TurfRating;
        private final Button TurfPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TurfIV = itemView.findViewById(R.id.IVTurfImage);
            TurfNameTV = itemView.findViewById(R.id.TVTurfName);
            TurfAreaTV = itemView.findViewById(R.id.TVTurfArea);
            TurfRating = itemView.findViewById(R.id.ratingBar);
            TurfPrice = itemView.findViewById(R.id.btn_price);
        }
    }

}
