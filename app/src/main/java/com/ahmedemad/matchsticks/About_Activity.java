package com.ahmedemad.matchsticks;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class About_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }


    public void facebookshare(View v)
    {
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/ahmed.e.barakat.94"));
        startActivity(i);
    }

    public void twittershare(View v)
    {
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://twitter.com/7AMADAH94"));
        startActivity(i);
    }

    public void googleshare(View v)
    {
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://plus.google.com/u/0/102310945573987410090"));
        startActivity(i);
    }
}