package com.zkhan.majorandroidcomponents.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;

import com.zkhan.majorandroidcomponents.R;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by FZKHANCORPORATION on 5/7/2015.
 */


public class MyService extends Service {

    // Once this class is activated, all the override methods are invoked except onDestroy.
    // Therefore, in order to use TextToSpeech engine, I needed to create a counter so that
    // I could invoke the text2speech engine both when the serivice is started and when
    // the service is stopped.

    private TextToSpeech t2s;
    int counter = 0;


    private static final String TAG = "MyService";
    private static final String String = null;




    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, R.string.myservice_started, Toast.LENGTH_LONG).show();

        Bundle extra = intent.getExtras();
       // final String receive = (String) extra.get("mstartService");
        final String receive = intent.getStringExtra("mstartService");

        t2s = new TextToSpeech(MyService.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                    if (status == t2s.SUCCESS) {
                        int result = t2s.setLanguage(Locale.US);
                        if (result == t2s.LANG_MISSING_DATA
                                || result == t2s.LANG_NOT_SUPPORTED) {
                            Log.e("error", "This Language is not supported");
                        } else {
                                 convertTextToSpeech1();
                        }


                    } else {
                        Log.e("error", "Initilization Failed!");
                    }

                }
      });






        return START_STICKY;

    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, R.string.myservice_stopped, Toast.LENGTH_LONG).show();
        convertTextToSpeech2();
        // Don't forget to shutdown tts!
        //if (t2s != null) {
        //    t2s.stop();
        //    t2s.shutdown();
        //}
        super.onDestroy();

        //t2s.shutdown();

    }


        /**
         * Releases the resources used by the TextToSpeech engine. It is good
         * practice for instance to call this method in the onDestroy() method of an
         * Activity so the TextToSpeech engine can be cleanly stopped.
         *
         * @see android.app.Activity#onDestroy()
         */


        /*
         * Speaks the string using the specified queuing strategy and speech
         * parameters.
         * @param test
         */
        private void convertTextToSpeech1() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ttsGreater21(getString(R.string.myservice_started));
            } else {
                ttsUnder20(getString(R.string.myservice_started));
            }


        }



    private void convertTextToSpeech2() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ttsGreater21(getString(R.string.myservice_stopped));
            } else {
                ttsUnder20(getString(R.string.myservice_stopped));
            }

        }


    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        t2s.speak(text, TextToSpeech.QUEUE_FLUSH, map);
        //t2s.shutdown();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text) {
        String utteranceId=this.hashCode() + "";
        t2s.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
        //t2s.shutdown();
    }



 }
