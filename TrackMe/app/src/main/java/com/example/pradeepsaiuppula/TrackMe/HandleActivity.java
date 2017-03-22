package com.example.pradeepsaiuppula.TrackMe;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.example.pradeepsaiuppula.myapplication.R;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.List;

/**
 * Created by pradeepsaiuppula on 2/9/17.
 */

public class HandleActivity extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    UploadData d=new UploadData();

    public HandleActivity(String name) {
        super(name);
    }
    public HandleActivity(){
        //don't remove this line.
        super("Handle Activity");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("Hellooooo","do you even come here");
        if(ActivityRecognitionResult.hasResult(intent)) {
            ActivityRecognitionResult result = ActivityRecognitionResult.extractResult(intent);
            handleDetectedActivities( result.getProbableActivities() );
        }
    }

    private void handleDetectedActivities(List<DetectedActivity> probableActivities) {
        int Threshold=0;
        for( DetectedActivity activity : probableActivities ) {
            switch( activity.getType() ) {
                case DetectedActivity.IN_VEHICLE: {
                    Log.e( "ActivityRecogition", "In Vehicle: " + activity.getConfidence() );
                    if( activity.getConfidence() >= Threshold ) {
                        d.upload_activity("drving"+activity.getConfidence());
                    }
                    break;
                }
                case DetectedActivity.ON_BICYCLE: {
                    Log.e( "ActivityRecogition", "On Bicycle: " + activity.getConfidence() );
                    if( activity.getConfidence() >= Threshold ) {
                        d.upload_activity("on_bicycle" + activity.getConfidence());
                    }
                    break;
                }
                case DetectedActivity.ON_FOOT: {
                    Log.e( "ActivityRecogition", "On Foot: " + activity.getConfidence() );
                    if( activity.getConfidence() >= Threshold ) {
                        d.upload_activity("ON_FOOT"+activity.getConfidence());
                    }
                    break;
                }
                case DetectedActivity.RUNNING: {
                    Log.e( "ActivityRecogition", "Running: " + activity.getConfidence() );
                    if( activity.getConfidence() >= Threshold ) {
                        d.upload_activity("running"+activity.getConfidence());
                    }
                    break;
                }
                case DetectedActivity.STILL: {
                    Log.e( "ActivityRecogition", "Still: " + activity.getConfidence() );
                    if( activity.getConfidence() >= Threshold ) {
                        d.upload_activity("still"+activity.getConfidence());
                    }
                    break;
                }
//                case DetectedActivity.TILTING: {
//                    Log.e( "ActivityRecogition", "Tilting: " + activity.getConfidence() );
//                    break;
//                }
                case DetectedActivity.WALKING: {
                    Log.e( "ActivityRecogition", "Walking: " + activity.getConfidence() );
                    if( activity.getConfidence() >= Threshold ) {
                        d.upload_activity("walking"+activity.getConfidence());
                    }
                    break;
                }
                case DetectedActivity.UNKNOWN: {
                    Log.e( "ActivityRecogition", "Unknown: " + activity.getConfidence() );
                    if( activity.getConfidence() >= Threshold ) {
                        d.upload_activity("unknown" + activity.getConfidence());
                    }
                    break;
                }
            }
        }
    }
    @Override
    public void onDestroy() {
        stopSelf();
        super.onDestroy();
    }
}
