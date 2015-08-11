package com.zkhan.majorandroidcomponents.broadcast_rxer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.zkhan.majorandroidcomponents.R;

/**
 * Created by Zeeshan Khan on 8/06/2015.
 * I created a new activity where I can write a message in edit text section and
 * broadcast it through Broadcast receiver
 */
public class CustomIntent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       return true;
    }

    public void broadcastCustomIntent(View view)
    {
        Intent intent = new Intent("MyCustomIntent");
        EditText et = (EditText)findViewById(R.id.extraIntent);
        // add data to the Intent
        intent.putExtra("message", (CharSequence)et.getText().toString());
        intent.setAction("com.zkhan.majorandroidcomponents.broadcast_rxer.A_CUSTOM_INTENT");
        sendBroadcast(intent);
    }

}