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

    public void upload(Accelerometer a,Gyroscope g,StepCounter s){

//            String temp_time=String.format("%.2f", (System.currentTimeMillis() - logTime) / 1000.0f);
            String temp_time = System.currentTimeMillis() +"";
            ref.child(temp_time).child("acceleration").setValue(a);
            ref.child(temp_time).child("gyroscope").setValue(g);
            ref.child(temp_time).child("stepcount").setValue(s);
    }
    public void upload_gps(Location l){

//            String temp_time=String.format("%.2f", (System.currentTimeMillis() - logTime) / 1000.0f);
        String temp_time = System.currentTimeMillis() +"";
        ref.child("Location").child(temp_time).setValue(l);
        //ref.setValue("Uncomment to erase the entire database.");
    }
    public void upload_activity(int val){
        ref.child("Activity").setValue(val);
    }

    public void clear_db(){
        ref.setValue("Destruted !!!!!!!!");
    }
}
