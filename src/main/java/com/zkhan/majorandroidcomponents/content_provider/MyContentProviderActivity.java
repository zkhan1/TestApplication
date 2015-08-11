
/*
* Created by Zeeshan Khan
* This class is the main class of my content provider and it does the following operations:
* 1- Add database entry
* 2 - Retrieve the entries into a different screen (crud activity)
* 3 - Delete the entries
 */


package com.zkhan.majorandroidcomponents.content_provider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zkhan.majorandroidcomponents.R;


public class MyContentProviderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_content_provider);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_content, menu);
        return true;
    }

    public void onClickAddName(View view) {
            ContentValues values = new ContentValues();
            values.put(MyContentProvider.name, ((EditText) findViewById(R.id.txtName))
                .getText().toString());
            Uri uri = getContentResolver().insert(MyContentProvider.CONTENT_URI, values);
            Toast.makeText(getBaseContext(), "New record inserted", Toast.LENGTH_LONG)
                .show();
    }

    public void onClickRetrieve (View view) { // to retrieve values from a content provider
        Intent retrieveValues = new Intent(this, MyContentProviderCRUD.class);
        startActivity(retrieveValues);
    }

    public void onClickDelete(View v) {  // to delete database entries from a content provider
        ContentResolver del = getContentResolver();
        del.delete(MyContentProvider.CONTENT_URI, null, null);

    }

    }

