package com.zkhan.majorandroidcomponents.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zkhan.majorandroidcomponents.R;


public class MyServiceActivity extends Activity {

    //private static String  mstartService;
    //private static String mstopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void onClickStartService(View view) {
        //mcounter = 0;
        Intent serviceStartIntent = new Intent(this, MyService.class);
        //serviceStartIntent.putExtra("mstartService", mstartService); // putExtra(key, value)
        // start service
        startService(serviceStartIntent);


    }


    public void onClickStopService(View view) {
       // mcounter = 1;
        Intent serviceStopIntent = new Intent(this, MyService.class);
        //serviceStopIntent.putExtra("mstopService", mstopService);
        // stop service
        stopService(serviceStopIntent);

    }
}
