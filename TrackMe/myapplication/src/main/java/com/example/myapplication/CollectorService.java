package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.hardware.*;
import android.hardware.Sensor;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.pradeepsaiuppula.myapplication.R;
import com.google.android.gms.awareness.fence.DetectedActivityFence;
import com.google.android.gms.awareness.snapshot.DetectedActivityResult;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

/**
 * Created by pradeepsaiuppula on 2/5/17.
 */

public class CollectorService extends Service implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor sensor;
    SensorFactory generator = new SensorFactory();
    UploadData d=new UploadData();

    Accelerometer acceleration   = (Accelerometer) generator.getSensor("Accelerometer");
    Gyroscope gyroscope          = (Gyroscope) generator.getSensor("Gyroscope");
    StepCounter stepCounter      = (StepCounter) generator.getSensor("Stepcount");


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
        sensorManager.registerListener(this, sensor,SensorManager.SENSOR_DELAY_NORMAL);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);



        return START_STICKY;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType()==sensor.TYPE_ACCELEROMETER){
            acceleration.setData(event.values[0],event.values[1],event.values[2]);
            d.upload_accel(acceleration);
        }
        if(event.sensor.getType()==sensor.TYPE_GYROSCOPE){
            gyroscope.setData(event.values[0],event.values[1],event.values[2]);
            d.upload_gyro(gyroscope);
        }
        if(event.sensor.getType() == sensor.TYPE_STEP_COUNTER){
            stepCounter.setData(event.values[0]);
            d.upload_step(stepCounter);
        }
        Log.d("hi","debug");



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.e("onAccuracy®Changed",""+accuracy);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

}
