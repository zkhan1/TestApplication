package com.zkhan.majorandroidcomponents.multi_threading;

/**
 * Created by Zeeshan Khan on 7/9/2015.

public class LoadWebPageFromInternet extends AsyncTask<String, String, String> {

    private Context context;

    //  public DownloadMusicFromInternet(Context context) {
    //      this.context = context;
    //  }


    // Show Progress Bar before downloading the Music
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Shows Progress Bar Dialog and then call doInBackground method


    }

    // Download Music File from Internet
    @Override
    protected String doInBackground(String... f_url) {
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(f_url[0]);

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
        // Dismiss the dialog after the Music file was downloaded
        // dismissDialog(progress_bar_type);
        Toast.makeText(context, "Download complete, playing Music", Toast.LENGTH_LONG).show();
        // Play the music
        // playMusic();
    }


}


*/