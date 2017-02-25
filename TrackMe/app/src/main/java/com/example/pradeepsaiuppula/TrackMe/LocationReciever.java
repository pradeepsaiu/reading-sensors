package com.example.pradeepsaiuppula.TrackMe;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by pradeepsaiuppula on 2/9/17.
 */
public class LocationReciever extends Service  {

    private final static String tag = "TestGps";

    private static int RATE = 100;  //100 -> 10 samples/s 50 -> 20 samples/s 20 -> 50 samples/s
    UploadData d = new UploadData();
    private LocationManager locationManager;
    private double latitude, longitude;
//    private static Double longitude= new Double(0.0);



    private static final String[] INITIAL_PERMS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_CONTACTS
    };

//    Timer timer;


    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            d.upload_gps(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
//            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, locationListener);
        }
        catch(SecurityException e){
            e.getStackTrace();
        }

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
//        timer.cancel();
        try {
            locationManager.removeUpdates(locationListener);
        }
        catch(SecurityException e) {
            e.getStackTrace();
        }
    }

}