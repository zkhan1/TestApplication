package com.zkhan.majorandroidcomponents.broadcast_rxer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;



/**
 * Created by Zeeshan Khan on 4/21/2015.
 * This class receives the message through intent from Android System using Broadcast receiver
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
         // Extract data included in the Intent
        CharSequence intentData = intent.getCharSequenceExtra("message");
        Toast.makeText(context, "ZK received the Intent's message: "+intentData, Toast.LENGTH_LONG).show();

    }
}


