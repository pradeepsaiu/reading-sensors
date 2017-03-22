package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView mTextView;
    private int flag=1;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    /*
    Called when onclick activity triggers.
    * */
    public void startService(View view) {

        if(flag == 1) {
            Log.e("enters ","start command");
            Toast.makeText(this, "Starting the service", Toast.LENGTH_SHORT).show();
            //Starting the background service
            startService(new Intent(getBaseContext(), CollectorService.class));
            /*
                TO start multiple services
            */
//            startService(new Intent(getBaseContext(), HandleActivity.class));
//            startService(new Intent(getBaseContext(), LocationReciever.class));

////        Are u sure you want to clear the database?
//        Log.e("db","clearing the database");
//        UploadData d = new UploadData();
//         d.clear_db();
            flag=0;
        }
        else{
//            b.setText("Start");
            Toast.makeText(this, "Stopping the service", Toast.LENGTH_SHORT).show();

            stopService(new Intent(getBaseContext(), CollectorService.class));
            flag=1;
        }
    }
}
