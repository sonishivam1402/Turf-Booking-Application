package com.example.turfbookingapp;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.turfbookingapp.databinding.ActivityMapsBinding;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private String TurfName;
    String marker;
    private LatLng mkr;

    // below are the latitude and longitude
    // of 4 different locations.
//    LatLng Turf106 = new LatLng(22.304372951667684, 73.12184456065236);
//    LatLng TheEclipse = new LatLng(22.336407956224857, 73.12292836984534);
//    LatLng Hattrick = new LatLng(22.353572283307333, 73.17656057778694);
//    LatLng Delta9 = new LatLng(22.329110908449245, 73.162939139155);
//    LatLng HuddleArena = new LatLng(22.29761671470262, 73.13304456983265);

//    // creating array list for adding all our locations.
    private ArrayList<LatLng> locationArrayList;
    private ArrayList<String> markerInPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        // in below line we are initializing our array list.
        locationArrayList = new ArrayList<>();

        // on below line we are adding our
        // locations in our array list.
//        locationArrayList.add(Turf106);
//        locationArrayList.add(TheEclipse);
//        locationArrayList.add(Hattrick);
//        locationArrayList.add(Delta9);
//        locationArrayList.add(HuddleArena);
//
//        markerInPosition = new ArrayList<>();
//
//        markerInPosition.add("Turf 106");
//        markerInPosition.add("The Eclipse Sports");
//        markerInPosition.add("Hattrick");
//        markerInPosition.add("Delta9");
//        markerInPosition.add("Huddle Arena");
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        marker = getIntent().getStringExtra("Turf Name");

        if(marker.matches("Hattrick")) {
            mkr = new LatLng(22.353572283307333, 73.17656057778694);
            mMap.addMarker(new MarkerOptions().position(mkr).title("Marker in Chhani"));
        } else if(marker.matches("Turf 106")) {
            mkr = new LatLng(22.304372951667684, 73.12184456065236);
            mMap.addMarker(new MarkerOptions().position(mkr).title("Marker in Sevasi"));
        } else if(marker.matches("The Eclipse Sports")) {
            mkr = new LatLng(22.336407956224857, 73.12292836984534);
            mMap.addMarker(new MarkerOptions().position(mkr).title("Marker in New Alkapuri"));
        } else if(marker.matches("Delta 9")) {
            mkr = new LatLng(22.329110908449245, 73.162939139155);
            mMap.addMarker(new MarkerOptions().position(mkr).title("Marker in Gorwa"));
        } else if(marker.matches("Huddle Arena")) {
            mkr = new LatLng(22.29761671470262, 73.13304456983265);
            mMap.addMarker(new MarkerOptions().position(mkr).title("Marker in Vasna - Bhayli"));
        } else if(marker=="Gameplex Arena") {
            mkr = new LatLng(22.320611834671244, 73.15771836074914);
            mMap.addMarker(new MarkerOptions().position(mkr).title("Marker in Subhanpura"));
        } else {
            mkr = new LatLng(22.325463879207227, 73.17309511657088);
            mMap.addMarker(new MarkerOptions().position(mkr).title("Marker in Gorwa"));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(mkr));

        // we will be displaying all our markers.
        // for adding markers we are running for loop and
        // inside that we are drawing marker on our map.


        mMap.setMinZoomPreference(12.0f);
        mMap.setMaxZoomPreference(18.0f);

//        for (int i = 0; i < locationArrayList.size(); i++) {
//
//            // below line is use to add marker to each location of our array list.
//            mMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title(markerInPosition.get(i)));
//
//            // below lin is use to zoom our camera on map.
//            mMap.animateCamera(CameraUpdateFactory.zoomTo(10.0f));
//
//            // below line is use to move our camera to the specific location.
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList.get(i)));
//        }
    }
}