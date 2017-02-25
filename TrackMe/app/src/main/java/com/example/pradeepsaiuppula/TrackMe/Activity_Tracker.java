package com.example.pradeepsaiuppula.TrackMe;

import android.app.IntentService;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.example.pradeepsaiuppula.myapplication.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;

import java.util.List;

/**
 * Created by pradeepsaiuppula on 2/9/17.
 */

public class Activity_Tracker extends Service implements  GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener{


    public GoogleApiClient mApiClient;

    protected void onHandleIntent(Intent intent) {
        Log.d("intent","Handling intent");


    }

    @Override
    public void onCreate() {
        Log.d("creating","just created---------------------");
        mApiClient = new GoogleApiClient.Builder(this)
                .addApi(ActivityRecognition.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        mApiClient.connect();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("activity","coneected®");

        return super.onStartCommand(intent, flags, startId);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("intent","Handling intent");
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d("intent","Onrebind");
        super.onRebind(intent);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d("activity","coneected---------------------");
        Intent intent = new Intent( this, HandleActivity.class );
        PendingIntent pendingIntent = PendingIntent.getService( this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT );
        ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates( mApiClient, 500, pendingIntent );

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onDestroy() {
        mApiClient.disconnect();
        stopSelf();
        super.onDestroy();
    }
}
