package com.zkhan.majorandroidcomponents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zkhan.majorandroidcomponents.broadcast_rxer.CustomIntent;
import com.zkhan.majorandroidcomponents.content_provider.MyContentProviderActivity;
import com.zkhan.majorandroidcomponents.database.MyDatabaseActivity;
import com.zkhan.majorandroidcomponents.multi_threading.AsyncTaskActivity;
import com.zkhan.majorandroidcomponents.multi_threading.MultipleThreadActivity;
import com.zkhan.majorandroidcomponents.service.MyServiceActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
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

    public void onButtonLaunchWebsite(View website) {
        Uri uri = Uri.parse("https://github.com/zkhan1");
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(websiteIntent);

    }

    public void onButtonMyReceiverIntent(View view) {
      //  Intent broadcastIntent = new Intent();
      //  broadcastIntent.setAction("com.zkhan.majorandroidcomponents.broadcast_rxer");
       // sendBroadcast(broadcastIntent);

        Intent myCustomIntent = new Intent(this, CustomIntent.class);
        startActivity(myCustomIntent);


    }


    public void onButtonMyContentProvider(View view) {
        Intent myContentProviderIntent = new Intent(this, MyContentProviderActivity.class);
        startActivity(myContentProviderIntent);
    }


    public void onButtonMyService(View view) {
        Intent myService = new Intent(this, MyServiceActivity.class);
        startActivity(myService);
    }

    public void onButtonMultiThread(View view) {

        String logsCat = null;
        try {
            Process process = Runtime.getRuntime().exec("logcat -d");


            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            StringBuilder log = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line);
            }
            //      TextView tv = (TextView)findViewById(R.id.checkLogcat);
            //      tv.setText(log.toString());
            logsCat = log.toString();

        } catch (IOException e) {
        }
        finally {

           // Toast.makeText(getApplicationContext(), "ZK logcat: "+logsCat, Toast.LENGTH_LONG).show();
            Intent myMultipleThread = new Intent(this, MultipleThreadActivity.class);

            myMultipleThread.putExtra("logsCat", logsCat);
            startActivity(myMultipleThread);
        }

    }

    public void onButtonAsynkTask (View view) {

        Intent myAsynkTask = new Intent(this, AsyncTaskActivity.class);
        startActivity(myAsynkTask);


    }

    public void onButtonMyDatabase (View view) {
        Intent myDatabase = new Intent(this, MyDatabaseActivity.class);
        startActivity(myDatabase);
    }

}
