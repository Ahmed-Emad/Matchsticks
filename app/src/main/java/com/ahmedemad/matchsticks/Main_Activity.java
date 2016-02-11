package com.ahmedemad.matchsticks;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class Main_Activity extends Activity {

    public static Boolean Sound = true;
    Switch S_Sound;
    ImageView Play;


    private View mDecorView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDecorView = getWindow().getDecorView();
        setContentView(R.layout.activity_main);

        S_Sound = (Switch) findViewById(R.id.S_Sound);

        Play = (ImageView) findViewById(R.id.Play);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChooseLevel_Activity.class);
                startActivity(intent);
            }
        });
    }

    public void onSoundClicked(View view) {

        boolean SoundOn = ((Switch) view).isChecked();
        if (SoundOn)
            Sound = true;

        else
            Sound = false;

    }

    public void About(View view)
    {
        Intent intent = new Intent(this, About_Activity.class);
        startActivity(intent);
    }

    public void How(View view)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("How To Play ?!");
        alertDialog.setMessage("-Make True Equations with one move by Touching a matchstick to move it up.\n-Touch an empty space to place the matchstick you have in it.\n"
        +"-The Top matchstick means you are carrying a matchstick\nTouch it to replace in its place");
        alertDialog.setButton("Let's Play", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialog.show();
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
