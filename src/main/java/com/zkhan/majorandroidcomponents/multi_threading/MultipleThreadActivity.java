package com.zkhan.majorandroidcomponents.multi_threading;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zkhan.majorandroidcomponents.R;


public class MultipleThreadActivity extends Activity {

    private static final String viewTag = "Main Thread: Main Thread: Running";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_thread);

        final String viewTag = "Main Thread: Runing";

        TextView tm = (TextView) findViewById(R.id.checkLogcat);
        // Main program runs with a single main thread
        for (int i = 0; i < 19; i++) {
           Log.v(viewTag, String.valueOf(R.string.threadMainRunning));
        }



        //First Approach: MyThreadClass by extending Thread class
        MyThreadClass myThread = new MyThreadClass();
        myThread.start();



        // Second Approach (Best approach): myRunnable class by implementing Runnable class
        MyRunnableClass myRunnableClass = new MyRunnableClass();
        Thread t3 = new Thread(myRunnableClass);
        t3.start();


        String logs = null;
        Bundle extras = getIntent().getExtras();
        logs = extras.getString("logsCat");

        TextView tv = (TextView)findViewById(R.id.checkLogcat);
        tv.setText(logs.toString());
        tv.setMovementMethod(new ScrollingMovementMethod());  // To make textview scrollable

        Uri uri = Uri.parse("https://gist.github.com/zkhan1/7abfe20f3eddd9f7b40f#file-logcat_multi-threading");
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(websiteIntent);

    }

    public TextView getTextView()
    {
      //  String logs = null;
    //    Bundle extras = getIntent().getExtras();
     //   logs = extras.getString("logsCat");

    //    TextView tv = (TextView)findViewById(R.id.checkLogcat);
     //   tv.setText(logs.toString());
     //   TextView txtView = (TextView)findViewById(R.id.checkLogcat);
      //  return txtView;
         return null;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multiple_thread, menu);
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
}
