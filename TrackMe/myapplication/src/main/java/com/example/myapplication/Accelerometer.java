package com.example.myapplication;

/**
 * Created by pradeepsaiuppula on 2/4/17.
 */

public class Accelerometer implements Sensor {

    public Float accel_x,accel_y,accel_z;

    public void setData(Float x,Float y,Float z){
        setAccel_x(x);
        setAccel_y(y);
        setAccel_z(z);
    }

    public Float getAccel_z() {
        return accel_z;
    }

    public void setAccel_z(Float accel_z) {
        this.accel_z = accel_z;
    }

    public Float getAccel_x() {
        return accel_x;
    }

    public void setAccel_x(Float accel_x) {
        this.accel_x = accel_x;
    }

    public Float getAccel_y() {
        return accel_y;
    }

    public void setAccel_y(Float accel_y) {
        this.accel_y = accel_y;
    }
}
