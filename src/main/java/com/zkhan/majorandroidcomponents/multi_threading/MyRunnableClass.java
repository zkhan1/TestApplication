package com.zkhan.majorandroidcomponents.multi_threading;

import android.util.Log;

import com.zkhan.majorandroidcomponents.R;

/**
 * Created by Zeeshan Khan on 7/28/2015.
 */
public class MyRunnableClass implements Runnable {


    private static final String viewTag = "Child Thread: Runnable Method Running";

    @Override
    public void run() {


        for (int i = 0; i < 19; i++) {

            Log.v(viewTag, String.valueOf(R.string.threadRunnableRunning)); // Output can be seen in logcat

        }

    }


}
