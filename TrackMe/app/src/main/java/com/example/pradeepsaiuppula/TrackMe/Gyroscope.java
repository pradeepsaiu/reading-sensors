package com.example.pradeepsaiuppula.TrackMe;

/**
 * Created by pradeepsaiuppula on 2/4/17.
 */

public class Gyroscope implements Sensor {

    public Float gyro_x,gyro_y,gyro_z;

    public void setData(Float x,Float y,Float z){
        setGyro_x(x);
        setGyro_y(y);
        setGyro_z(z);
    }

    public Float getGyro_x() {
        return gyro_x;
    }

    public void setGyro_x(Float gyro_x) {
        this.gyro_x = gyro_x;
    }

    public Float getGyro_y() {
        return gyro_y;
    }

    public void setGyro_y(Float gyro_y) {
        this.gyro_y = gyro_y;
    }

    public Float getGyro_z() {
        return gyro_z;
    }

    public void setGyro_z(Float gyro_z) {
        this.gyro_z = gyro_z;
    }
}
