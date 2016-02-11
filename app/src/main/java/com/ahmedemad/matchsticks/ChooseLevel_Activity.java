package com.ahmedemad.matchsticks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class ChooseLevel_Activity extends Activity {

    GridView gridview;
    private View mDecorView;

    SharedPreferences sharedpreferences;
    GridAdapter Adapter;

    int LastLevel;

    public static final String MyPrefrrencesKEY = "Score" ;
    public static final String LastLevelKEY = "LastLevel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDecorView = getWindow().getDecorView();
        setContentView(R.layout.activity_choose_level);

        sharedpreferences = getSharedPreferences(MyPrefrrencesKEY, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(LastLevelKEY))
        {
            LastLevel = sharedpreferences.getInt(LastLevelKEY, 0);
        }
        else {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putInt(LastLevelKEY, 0);  /////////////////////////////////////
            editor.commit();
            LastLevel = sharedpreferences.getInt(LastLevelKEY, 0);
        }

        Adapter = new GridAdapter(this, LastLevel);

        //Log.e("Main", "Last Level = " + LastLevel);
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(Adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (++position <= LastLevel+1) {
                    Bundle dataBundle = new Bundle();
                    dataBundle.putInt("LevelNo", position);
                    Intent intent = new Intent(getApplicationContext(), Levels_Activity.class);
                    intent.putExtras(dataBundle);
                    startActivity(intent);

                    /*
                    switch (position) {
                        case 1:
                            Intent intent001 = new Intent(getApplicationContext(), Level001_Activity.class);
                            startActivity(intent001);
                            break;
                        case 2:
                            Intent intent002 = new Intent(getApplicationContext(), Level002_Activity.class);
                            startActivity(intent002);
                            break;
                        case 3:
                            Intent intent003 = new Intent(getApplicationContext(), Level003_Activity.class);
                            startActivity(intent003);
                            break;
                        case 4:
                            Intent intent004 = new Intent(getApplicationContext(), Level004_Activity.class);
                            startActivity(intent004);
                            break;
                        case 5:
                            Intent intent005 = new Intent(getApplicationContext(), Level005_Activity.class);
                            startActivity(intent005);
                            break;
                        case 6:
                            Intent intent006 = new Intent(getApplicationContext(), Level006_Activity.class);
                            startActivity(intent006);
                            break;
                        case 7:
                            Intent intent007 = new Intent(getApplicationContext(), Level007_Activity.class);
                            startActivity(intent007);
                            break;
                        case 8:
                            Intent intent008 = new Intent(getApplicationContext(), Level008_Activity.class);
                            startActivity(intent008);
                            break;
                        case 9:
                            Intent intent009 = new Intent(getApplicationContext(), Level009_Activity.class);
                            startActivity(intent009);
                            break;
                        case 10:
                            Intent intent010 = new Intent(getApplicationContext(), Level010_Activity.class);
                            startActivity(intent010);
                            break;
                        case 11:
                            Intent intent011 = new Intent(getApplicationContext(), Level011_Activity.class);
                            startActivity(intent011);
                            break;
                        case 12:
                            Intent intent012 = new Intent(getApplicationContext(), Level012_Activity.class);
                            startActivity(intent012);
                            break;
                        case 13:
                            Intent intent013 = new Intent(getApplicationContext(), Level013_Activity.class);
                            startActivity(intent013);
                            break;
                        case 14:
                            Intent intent014 = new Intent(getApplicationContext(), Level014_Activity.class);
                            startActivity(intent014);
                            break;
                        case 15:
                            Intent intent015 = new Intent(getApplicationContext(), Level015_Activity.class);
                            startActivity(intent015);
                            break;
                        case 16:
                            Intent intent016 = new Intent(getApplicationContext(), Level016_Activity.class);
                            startActivity(intent016);
                            break;
                        case 17:
                            Intent intent017 = new Intent(getApplicationContext(), Level017_Activity.class);
                            startActivity(intent017);
                            break;
                        case 18:
                            Intent intent018 = new Intent(getApplicationContext(), Level018_Activity.class);
                            startActivity(intent018);
                            break;
                        case 19:
                            Intent intent019 = new Intent(getApplicationContext(), Level019_Activity.class);
                            startActivity(intent019);
                            break;
                        case 20:
                            Intent intent020 = new Intent(getApplicationContext(), Level020_Activity.class);
                            startActivity(intent020);
                            break;
                        case 21:
                            Intent intent021 = new Intent(getApplicationContext(), Level021_Activity.class);
                            startActivity(intent021);
                            break;
                        case 22:
                            Intent intent022 = new Intent(getApplicationContext(), Level022_Activity.class);
                            startActivity(intent022);
                            break;
                        case 23:
                            Intent intent023 = new Intent(getApplicationContext(), Level023_Activity.class);
                            startActivity(intent023);
                            break;
                        case 24:
                            Intent intent024 = new Intent(getApplicationContext(), Level024_Activity.class);
                            startActivity(intent024);
                            break;
                        case 25:
                            Intent intent025 = new Intent(getApplicationContext(), Level025_Activity.class);
                            startActivity(intent025);
                            break;
                        case 26:
                            Intent intent026 = new Intent(getApplicationContext(), Level026_Activity.class);
                            startActivity(intent026);
                            break;
                        case 27:
                            Intent intent027 = new Intent(getApplicationContext(), Level027_Activity.class);
                            startActivity(intent027);
                            break;
                        case 28:
                            Intent intent028 = new Intent(getApplicationContext(), Level028_Activity.class);
                            startActivity(intent028);
                            break;
                        case 29:
                            Intent intent029 = new Intent(getApplicationContext(), Level029_Activity.class);
                            startActivity(intent029);
                            break;
                        case 30:
                            Intent intent030 = new Intent(getApplicationContext(), Level030_Activity.class);
                            startActivity(intent030);
                            break;
                        case 31:
                            Intent intent031 = new Intent(getApplicationContext(), Level031_Activity.class);
                            startActivity(intent031);
                            break;
                        case 32:
                            Intent intent032 = new Intent(getApplicationContext(), Level032_Activity.class);
                            startActivity(intent032);
                            break;
                        case 33:
                            Intent intent033 = new Intent(getApplicationContext(), Level033_Activity.class);
                            startActivity(intent033);
                            break;

                    }
                    */

                    //Toast.makeText(getApplicationContext(), "" + position, Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "L O C K E D", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onResume()
    {
        super.onResume();

        LastLevel = sharedpreferences.getInt(LastLevelKEY, 0);

        Adapter.setLastlevel(LastLevel);
        Adapter.notifyDataSetChanged();

        try {
            Levels_Activity.Music.stop();
            Levels_Activity.Music.reset();
            Levels_Activity.Music.release();
            Levels_Activity.Music = null;
        }catch (NullPointerException e){}
    }

    @Override
    public void onPause()
    {
        super.onPause();
        try {
            Levels_Activity.Music.stop();
            Levels_Activity.Music.reset();
            Levels_Activity.Music.release();
            Levels_Activity.Music = null;
        }catch (NullPointerException e){}
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}
