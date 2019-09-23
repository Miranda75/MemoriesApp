package com.example.memoriesapp;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.security.Provider;

public class MainActivity<onMapReadyCallBack, MyLocationProvider> extends AppCompatActivity implements onMapReadyCallBack, OnMapReadyCallback {

    TextView userLocationText;
    MapView mapView;
    private static final int GPS_PERMISSION_REQUEST_CODE =1234;
    private GoogleMap googleMap;
    Provider provider;

    @Override
    protected <MyLocation> void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userLocationText = findViewById(R.id.user_location_text);
        mapView = findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        if (isGPSPermissionGranted()) {

        } else {
            askForGPSPermission();
        }
        GoogleMap googleMap;
        public void onMapReady(GoogleMap googleMap){
            this.googleMap=googleMap;
            drawUserMarkerOnMap();

        }
        Marker userMarker = null;
        public void drawUserMarkerOnMap(){
            MyLocation myLocation = null;
            if(myLocation==null)return;
            if(googleMap==null)return;

            if(userMarker==null)
             userMarker= googleMap.addMarker(new MarkerOptions()
            .position(new LatLng(myLocation.getLatitude(),myLocation.getLongitude()))
            .title("i'm here")
            .icon());
            else {
                userMarker.setPosition(new LatLng(myLocation.getLatitude(), myLocation.getLongitude()));
            }
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new
                LatLng(myLocation.getLatitude(),myLocation.getLongitude()),10f);
        }
        protected void onStart() {
            super.onStart();
            mapView.onStart();
        }
        protected void onResume(){
            super.onResume();
            mapView.onResume();
        }
        protected void onStop(){
            super.onStop();
            mapView.onStop();
        }
        protected void onPause(){
            super.onPause();
            mapView.onPause();
        }
        protected void onLowMemory(){
            super.onLowMemory();
            mapView.onLowMemory();
        }
        protected void onDestroy(){
            super.onDestroy();
            mapView.onDestroy();
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private boolean isGPSPermissionGranted() {
    }

    private void askForGPSPermission() {
        }
        MyLocationProvider LocationProvider;
        public void getUserLocation(){
            MyLocationProvider locationProvider;
            if(locationProvider==null);
            locationProvider=new MyLocationProvider(this);
            locationProvider.getUserLocation(new LocationListener){
                public void onLocationChanged(Location Location){
                    Location myLocation = null;
                    drawUserMarkerOnMap();
                    userLocationText.setText(myLocation.getProvider()+" "+myLocation+" "+myLocation.getLongitude());
                }
                public void onStatusChanged(String provider,int status);
            }
        }

    private void drawUserMarkerOnMap() {
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
