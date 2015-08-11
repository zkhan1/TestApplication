package com.zkhan.majorandroidcomponents.multi_threading;

import android.util.Log;

import com.zkhan.majorandroidcomponents.R;

/**
 * Created by Zeeshan Khan on 7/28/2015.
 */
public class MyThreadClass extends Thread {


    private static final String viewTag = "Child Thread: Extension Method Running";

    public void run() {

     for (int i = 0; i < 19; i++) {
           Log.v(viewTag, String.valueOf(R.string.threadExtensionRunning)); // Output can be seen in logcat

        }
    }


}
