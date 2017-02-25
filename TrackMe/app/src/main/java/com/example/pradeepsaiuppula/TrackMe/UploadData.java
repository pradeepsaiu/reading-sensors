package com.example.pradeepsaiuppula.TrackMe;

import android.hardware.*;
import android.hardware.Sensor;
import android.location.Location;

import com.google.android.gms.location.DetectedActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pradeepsaiuppula on 2/7/17.
 */

public class UploadData {

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference ref = db.getReference("");
    long logTime = System.currentTimeMillis();

    public void upload_accel(Accelerometer a){
            String temp_time = System.currentTimeMillis() +"";
            ref.child("acceleration").child(temp_time).setValue(a);
    }
    public void upload_gyro(Gyroscope g){
        String temp_time = System.currentTimeMillis() +"";
        ref.child("gyroscope").child(temp_time).setValue(g);
    }
    public void upload_step(StepCounter s){
        String temp_time = System.currentTimeMillis() +"";
        ref.child("stepcount").child(temp_time).setValue(s);
    }
    public void upload_gps(Location l){
        String temp_time = System.currentTimeMillis() +"";
        ref.child("Location").child(temp_time).setValue(l);
        //ref.setValue("Uncomment to erase the entire database.");
    }
    public void upload_activity(String val){
        String temp_time = System.currentTimeMillis() +"";
        ref.child("Activity").child(temp_time).setValue(val);
    }

    public void upload_test(String test){
        String temp_time = System.currentTimeMillis() +"";
        ref.child("test").child(temp_time).setValue(test);
    }

    public void clear_db(){
        ref.setValue("Destruted !!!!!!!!");
    }
}
