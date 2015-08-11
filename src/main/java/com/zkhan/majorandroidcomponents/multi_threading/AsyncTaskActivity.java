package com.zkhan.majorandroidcomponents.multi_threading;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zkhan.majorandroidcomponents.R;


public class AsyncTaskActivity extends Activity {

    final Context context = this;


    // Music resource URL
    private static String file_url = "https://soundcloud.com/keep-rocking-studio-2/tum-hi-ho-instrumental";  //http://programmerguru.com/android-tutorial/wp-content/uploads/2014/01/jai_ho.mp3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

   }



    public void onButtonDownloadWebPage(View view) {

      //  Toast.makeText(getApplicationContext(), "Sleep for 10 seconds then load web-page", Toast.LENGTH_LONG).show();

        Toast toast= Toast.makeText(getApplicationContext(),
                "Sleep for 10 seconds", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();


        Button setButton = (Button) findViewById(R.id.btnProgressBar);
        setButton.setText("Sleeping for 10 secs");
        LoadWebPageFromInternet task = new LoadWebPageFromInternet();
        task.execute(new String[] {file_url});
        setButton.setTextColor(getResources().getColor(R.color.red));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_async_task, menu);
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


    public void  onButtonMainThreadResponse (View view) {

        Toast.makeText(getApplicationContext(), "UI Main Thread is responsive", Toast.LENGTH_LONG).show();
    }



    private class LoadWebPageFromInternet extends AsyncTask<String, Void, String> {

        // Show Progress Bar before downloading the Music
        @Override
        protected void onPreExecute() {
          // Shows Progress Bar Dialog and then call doInBackground method
        }

        // Upload Web-Page
        @Override
        protected String doInBackground(String... f_url) {

            try {
                Thread.sleep(10000);
               //setButton.setText("Done Waiting");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             return null;


        }



        // While Downloading Music File
        protected void onProgressUpdate(String... progress) {
            // Set progress percentage
          //prgDialog.setProgress(Integer.parseInt(progress[0]));
        }

        // Once Music File is downloaded
        @Override
        protected void onPostExecute(String file_url) {
            Button setButton = (Button) findViewById(R.id.btnProgressBar);
            setButton.setText(R.string.asynctask_btn_title);
            setButton.setTextColor(getResources().getColor(R.color.white));
            //Toast.makeText(getApplicationContext(), "Done Sleeping for 10 secs", Toast.LENGTH_LONG).show();
            Toast toast= Toast.makeText(getApplicationContext(),
                    "Done Sleeping for 10 secs", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER| Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();

        }


    }
}
