package com.example.myapplication;

/**
 * Created by pradeepsaiuppula on 2/4/17.
 */

public class SensorFactory {

    public Sensor getSensor(String sensor_name){

        if(sensor_name.equalsIgnoreCase("accelerometer")){
            return new Accelerometer();
        }
        else if(sensor_name.equalsIgnoreCase("gyroscope")){
            return  new Gyroscope();
        }
        return null;
    }
}
