package com.example.pradeepsaiuppula.TrackMe;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pradeepsaiuppula.myapplication.R;
import com.google.android.gms.games.internal.GamesContract;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager mSensorManager;
        Sensor mSensor;


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = null;

        List<Sensor> gravSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        /*
        * Reality Check to display list of available sensors
        * */
        for(Sensor each : gravSensors){
            Log.e("Main_Activity",each.getName());
        }


    }

    public void startService(View view) {
        Toast.makeText(this, "Starting the service", Toast.LENGTH_SHORT).show();
        //Starting the background service
//        startService(new Intent(getBaseContext(), CollectorService.class));
        /*To start multiple background services*/
        startService(new Intent(getBaseContext(), Activity_Tracker.class));
//        startService(new Intent(getBaseContext(), LocationReciever.class));

////        Are u sure you want to clear the database? Firebase hack!!
//        Log.e("db","clearing the database");
//        UploadData d = new UploadData();
//         d.clear_db();
    }

    // Method to stop the service
    public void stopService(View view) {
        Toast.makeText(this, "Stopping the service", Toast.LENGTH_SHORT).show();
        Log.d("------------------","ENding service");
        stopService(new Intent(getBaseContext(), Activity_Tracker.class));
//        stopService(new Intent(getBaseContext(), LocationReciever.class));
//        stopService(new Intent(getBaseContext(), HandleActivity.class));
//        stopService(new Intent(getBaseContext(), CollectorService.class));

    }

}
