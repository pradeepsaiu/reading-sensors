package com.example.pradeepsaiuppula.TrackMe;

/**
 * Created by pradeepsaiuppula on 2/7/17.
 */

public class StepCounter implements Sensor {
    float count;

    public float getCount() {
        return count;
    }

    public void setData(float count){
        this.setCount(count);
    }

    public void setCount(float count) {
        this.count = count;
    }
}
