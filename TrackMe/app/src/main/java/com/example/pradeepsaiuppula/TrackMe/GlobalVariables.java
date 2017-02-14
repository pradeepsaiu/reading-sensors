package com.example.pradeepsaiuppula.TrackMe;

import android.app.Application;

/**
 * Created by pradeepsaiuppula on 2/10/17.
 */

public class GlobalVariables extends Application{

    public String activity;

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
