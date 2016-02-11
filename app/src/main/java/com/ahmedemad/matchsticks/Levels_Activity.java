package com.ahmedemad.matchsticks;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Levels_Activity extends Activity
{
    private int LevelNo = 0;
    private Bitmap matchstickright, matchstickright2, matchsticktop, matchsticktop2, right, top, plus, plus2, minus, yes, no;

    private View mDecorView;
    private SharedPreferences sharedpreferences;
    private final int state_none = -1, state_sign = 0, state_top = 1, state_right = 2;
    private int LastLevel;
    private int state;
    private Boolean up = false, halftrue1 = false, halftrue2 = false;
    public ImageView LastUP;

    TextView hint1, hint2;

    public static MediaPlayer Music;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mDecorView = getWindow().getDecorView();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            LevelNo = extras.getInt("LevelNo");
        }

        switch (LevelNo) {
            case 1:
                setContentView(R.layout.level001);
                hint1 = (TextView) findViewById(R.id.hint1);
                hint2 = (TextView) findViewById(R.id.hint2);
                break;
            case 2:
                setContentView(R.layout.level002);
                break;
            case 3:
                setContentView(R.layout.level003);
                break;
            case 4:
                setContentView(R.layout.level004);
                break;
            case 5:
                setContentView(R.layout.level005);
                break;
            case 6:
                setContentView(R.layout.level006);
                break;
            case 7:
                setContentView(R.layout.level007);
                break;
            case 8:
                setContentView(R.layout.level008);
                break;
            case 9:
                setContentView(R.layout.level009);
                break;
            case 10:
                setContentView(R.layout.level010);
                break;
            case 11:
                setContentView(R.layout.level011);
                break;
            case 12:
                setContentView(R.layout.level012);
                break;
            case 13:
                setContentView(R.layout.level013);
                break;
            case 14:
                setContentView(R.layout.level014);
                break;
            case 15:
                setContentView(R.layout.level015);
                break;
            case 16:
                setContentView(R.layout.level016);
                break;
            case 17:
                setContentView(R.layout.level017);
                break;
            case 18:
                setContentView(R.layout.level018);
                break;
            case 19:
                setContentView(R.layout.level019);
                break;
            case 20:
                setContentView(R.layout.level020);
                break;
            case 21:
                setContentView(R.layout.level021);
                break;
            case 22:
                setContentView(R.layout.level022);
                break;
            case 23:
                setContentView(R.layout.level023);
                break;
            case 24:
                setContentView(R.layout.level024);
                break;
            case 25:
                setContentView(R.layout.level025);
                break;
            case 26:
                setContentView(R.layout.level026);
                break;
            case 27:
                setContentView(R.layout.level027);
                break;
            case 28:
                setContentView(R.layout.level028);
                break;
            case 29:
                setContentView(R.layout.level029);
                break;
            case 30:
                setContentView(R.layout.level030);
                break;
            case 31:
                setContentView(R.layout.level031);
                break;
            case 32:
                setContentView(R.layout.level032);
                break;
            case 33:
                setContentView(R.layout.level033);
                break;
            case 34:
                setContentView(R.layout.level034);
                break;
            case 35:
                setContentView(R.layout.level035);
                break;
            case 36:
                setContentView(R.layout.level036);
                break;
            case 37:
                setContentView(R.layout.level037);
                break;
            case 38:
                setContentView(R.layout.level038);
                break;
            case 39:
                setContentView(R.layout.level039);
                break;
            case 40:
                setContentView(R.layout.level040);
                break;
            case 41:
                setContentView(R.layout.level041);
                break;
            case 42:
                setContentView(R.layout.level042);
                break;
            case 43:
                setContentView(R.layout.level043);
                break;
            case 44:
                setContentView(R.layout.level044);
                break;
            case 45:
                setContentView(R.layout.level045);
                break;
            case 46:
                setContentView(R.layout.level046);
                break;
            case 47:
                setContentView(R.layout.level047);
                break;
            case 48:
                setContentView(R.layout.level048);
                break;
            case 49:
                setContentView(R.layout.level049);
                break;
            case 50:
                setContentView(R.layout.level050);
                break;

        }

        if (Main_Activity.Sound) {
            Music = MediaPlayer.create(this, R.raw.music);
            Music.start();
        }

        state = state_none;

        matchstickright = BitmapFactory.decodeResource(getResources(), R.drawable.matchstickright);
        matchstickright2 = BitmapFactory.decodeResource(getResources(), R.drawable.matchstickright2);
        matchsticktop = BitmapFactory.decodeResource(getResources(), R.drawable.matchsticktop);
        matchsticktop2 = BitmapFactory.decodeResource(getResources(), R.drawable.matchsticktop2);
        right = BitmapFactory.decodeResource(getResources(), R.drawable.right);
        top = BitmapFactory.decodeResource(getResources(), R.drawable.top);
        plus = BitmapFactory.decodeResource(getResources(), R.drawable.plus);
        plus2 = BitmapFactory.decodeResource(getResources(), R.drawable.plus2);
        minus = BitmapFactory.decodeResource(getResources(), R.drawable.minus);
        yes = BitmapFactory.decodeResource(getResources(), R.drawable.yes);
        no = BitmapFactory.decodeResource(getResources(), R.drawable.no);

        sharedpreferences = getSharedPreferences(ChooseLevel_Activity.MyPrefrrencesKEY, 0);
        LastLevel = sharedpreferences.getInt(ChooseLevel_Activity.LastLevelKEY, 0);
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

    @Override
    public void onDestroy() {
        super.onDestroy();

        try {
            Music.stop();
            Music.reset();
            Music.release();
            Music = null;
        }catch (NullPointerException e){}

    }

    @Override
    public void onStop() {
        super.onStop();

        try {
            Music.stop();
            Music.reset();
            Music.release();
            Music = null;
        }catch (NullPointerException e){}

    }

    @Override
    public void onResume()
    {
        super.onResume();

        if (Main_Activity.Sound) {
            try {
                if (!(Music.isPlaying())) {
                    if (!(Music.isPlaying()))
                        Music.start();
                }
            } catch (NullPointerException e) {
                Music = MediaPlayer.create(this, R.raw.music);
                Music.start();
            }
        }

    }

    public void Up(View view)
    {
        ImageView i = (ImageView)view;
        up(i);

        halftrue1 = false;
        halftrue2 = false;
    }

    public void Down(View view)
    {
        if (up)
        {
            ImageView i = (ImageView)view;
            down(i);
        }
    }

    public void UpTrue1(View view)
    {
        ImageView i = (ImageView)view;
        up(i);

        halftrue1 = true;
        halftrue2 = false;

        if (LevelNo == 1)
        {
            hint1.setVisibility(View.INVISIBLE);
            hint2.setVisibility(View.VISIBLE);
        }

    }

    public void UpTrue2(View view)
    {
        ImageView i = (ImageView)view;
        up(i);

        halftrue1 = false;
        halftrue2 = true;
    }

    public void DownTrue1(View view)
    {
        if (!halftrue1)
        {
            if (up)
            {
                ImageView i = (ImageView)view;
                down(i);
            }

        }
        else if (up) {
            ImageView i = (ImageView)view;
            switch (i.getId()) {
                case R.id.Top:
                    ((ImageView)view).setImageBitmap(matchsticktop);
                    break;
                case R.id.Right:
                    ((ImageView)view).setImageBitmap(matchstickright);
                    break;
                case R.id.Sign:
                    ((ImageView)view).setImageBitmap(plus);
            }

            up = false;
            ImageView r = (ImageView)findViewById(R.id.Return);
            r.setImageBitmap(top);

            if (LevelNo == 1)
            {
                hint1.setVisibility(View.INVISIBLE);
                hint2.setVisibility(View.INVISIBLE);
            }

            Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                public void run()
                {
                    ImageView y = (ImageView) findViewById(R.id.ResultSign);
                    ImageView firstNo = (ImageView) findViewById(R.id.FirstNo);
                    ImageView sign = (ImageView) findViewById(R.id.Sign2);
                    ImageView secondNo = (ImageView) findViewById(R.id.SecondNo);
                    ImageView equal = (ImageView) findViewById(R.id.Equal);
                    ImageView result = (ImageView) findViewById(R.id.Result);
                    y.setImageBitmap(yes);


                    switch (LevelNo) {
                        case 1:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n7));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n4));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n3));
                            break;
                        case 2:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n4));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n5));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            break;
                        case 3:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n9));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n0));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            break;
                        case 4:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n9));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n1));
                            break;
                        case 5:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n2));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n1));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n3));
                            break;
                        case 6:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n5));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n1));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            break;
                        case 7:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n3));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n4));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n7));
                            break;
                        case 8:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n0));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            break;
                        case 9:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n1));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n5));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            break;
                        case 10:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n2));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            break;
                        case 11:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n4));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n3));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n7));
                            break;
                        case 12:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n8));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n1));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            break;
                        case 13:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n5));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n3));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n2));
                            break;
                        case 14:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n8));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n7));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n1));
                            break;
                        case 15:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n1));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n7));
                            break;
                        case 16:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n9));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n3));
                            break;
                        case 17:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n9));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n3));
                            break;
                        case 18:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n9));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n0));
                            break;
                        case 19:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n4));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n2));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n2));
                            break;
                        case 20:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n2));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n7));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            break;
                        case 21:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n3));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n5));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            break;
                        case 22:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n3));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            break;
                        case 23:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n8));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n2));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            break;
                        case 24:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n7));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n2));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n5));
                            break;
                        case 25:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n0));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            break;
                        case 26:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n13));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n7));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            break;
                        case 27:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n8));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n16));
                            break;
                        case 28:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n9));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n18));
                            break;
                        case 29:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n5));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n11));
                            break;
                        case 30:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n3));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n12));
                            break;
                        case 31:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n8));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n16));
                            break;
                        case 32:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n9));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n7));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n16));
                            break;
                        case 33:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n5));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n13));
                            break;
                        case 34:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n6));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n12));
                            break;
                        case 35:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n4));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n7));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n11));
                            break;
                        case 36:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n7));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n16));
                            break;
                        case 37:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n10));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n18));
                            break;
                        case 38:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n10));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n2));
                            break;
                        case 39:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n6));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n14));
                            break;
                        case 40:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n3));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n11));
                            break;
                        case 41:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n1));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n10));
                            break;
                        case 42:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n5));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n13));
                            break;
                        case 43:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n9));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n15));
                            break;
                        case 44:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n8));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n16));
                            break;
                        case 45:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n16));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            break;
                        case 46:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n15));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            break;
                        case 47:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n7));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n10));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n17));
                            break;
                        case 48:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n8));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n2));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n10));
                            break;
                        case 49:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n19));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n11));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            break;
                        case 50:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n15));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n13));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n2));
                            break;

                    }


                    if (LastLevel < LevelNo) {
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putInt(ChooseLevel_Activity.LastLevelKEY, LevelNo);
                        editor.commit();
                        LastLevel = sharedpreferences.getInt(ChooseLevel_Activity.LastLevelKEY, LevelNo);
                    }
                }
            }
                    , 800);

            handler.postDelayed(new Runnable()
            {
                public void run() {
                    end();
                }
            }
                    , 1800);
        }
    }

    public void DownTrue2(View view)
    {
        if (!halftrue2)
        {
            if (up)
            {
                ImageView i = (ImageView)view;
                down(i);
            }

        }
        else if (up) {
            ImageView i = (ImageView)view;
            switch (i.getId()) {
                case R.id.Top:
                    ((ImageView)view).setImageBitmap(matchsticktop);
                    break;
                case R.id.Right:
                    ((ImageView)view).setImageBitmap(matchstickright);
                    break;
                case R.id.Sign:
                    ((ImageView)view).setImageBitmap(plus);
            }

            up = false;
            ImageView r = (ImageView) findViewById(R.id.Return);
            r.setImageBitmap(top);

            if (LevelNo == 1)
            {
                hint1.setVisibility(View.INVISIBLE);
                hint2.setVisibility(View.INVISIBLE);
            }

            Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                public void run()
                {
                    ImageView y = (ImageView) findViewById(R.id.ResultSign);
                    ImageView firstNo = (ImageView) findViewById(R.id.FirstNo);
                    ImageView sign = (ImageView) findViewById(R.id.Sign2);
                    ImageView secondNo = (ImageView) findViewById(R.id.SecondNo);
                    ImageView equal = (ImageView) findViewById(R.id.Equal);
                    ImageView result = (ImageView) findViewById(R.id.Result);
                    y.setImageBitmap(yes);


                    switch (LevelNo) {
                        case 1:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n1));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n4));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n5));
                            break;
                        case 3:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n3));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            break;
                        case 13:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n5));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n2));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n3));
                            break;
                        case 14:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n3));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n3));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            break;
                        case 15:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n7));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.minussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n0));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n7));
                            break;
                        case 18:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n5));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n3));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n8));
                            break;
                        case 24:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n1));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n2));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n3));
                            break;
                        case 25:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n6));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n0));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n6));
                            break;
                        case 42:
                            firstNo.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.n6));
                            sign.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.plussign));
                            secondNo.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n9));
                            equal.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.equalsign));
                            result.setImageBitmap(BitmapFactory.decodeResource(getResources(),  R.drawable.n15));
                            break;
                    }


                    if (LastLevel < LevelNo) {
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putInt(ChooseLevel_Activity.LastLevelKEY, LevelNo);
                        editor.commit();
                        LastLevel = sharedpreferences.getInt(ChooseLevel_Activity.LastLevelKEY, LevelNo);
                    }
                }
            }
                    , 800);

            handler.postDelayed(new Runnable()
            {
                public void run() {
                    end();
                }
            }
                    , 1800);
        }
    }

    public void Return(View view)
    {
        if (up)
        {
            switch (state)
            {
                case state_top:
                    LastUP.setImageBitmap(matchsticktop);
                    break;
                case state_right:
                    LastUP.setImageBitmap(matchstickright);
                    break;
                case state_sign:
                    LastUP.setImageBitmap(plus);
            }

            ((ImageView)view).setImageBitmap(top);
            up = false;
            state = state_none;

            if (LevelNo == 1)
            {
                hint1.setVisibility(View.VISIBLE);
                hint2.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void up(ImageView i)
    {
        if (up) {
            switch (state)
            {
                case state_top:
                    LastUP.setImageBitmap(matchsticktop);
                    break;
                case state_right:
                    LastUP.setImageBitmap(matchstickright);
                    break;
                case state_sign:
                    LastUP.setImageBitmap(plus);
            }

        }

        ImageView r = (ImageView)findViewById(R.id.Return);
        r.setImageBitmap(matchsticktop);

        up = true;
        LastUP = i;

        switch (LastUP.getId())
        {
            case R.id.Top:
                i.setImageBitmap(matchsticktop2);
                state = state_top;
                break;
            case R.id.Right:
                i.setImageBitmap(matchstickright2);
                state = state_right;
                break;
            case R.id.Sign:
                i.setImageBitmap(plus2);
                state = state_sign;
        }
    }

    private void down(final ImageView i)
    {
        switch (i.getId()) {
            case R.id.Top:
                i.setImageBitmap(matchsticktop);
                break;
            case R.id.Right:
                i.setImageBitmap(matchstickright);
                break;
            case R.id.Sign:
                i.setImageBitmap(plus);
        }

        up = false;
        ImageView r = (ImageView) findViewById(R.id.Return);
        r.setImageBitmap(top);

        if (LevelNo == 1)
        {
            hint1.setVisibility(View.VISIBLE);
            hint2.setVisibility(View.INVISIBLE);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            public void run() {
                ImageView n = (ImageView) findViewById(R.id.ResultSign);
                n.setImageBitmap(no);

                switch (state)
                {
                    case state_top:
                        LastUP.setImageBitmap(matchsticktop);
                        break;
                    case state_right:
                        LastUP.setImageBitmap(matchstickright);
                        break;
                    case state_sign:
                        LastUP.setImageBitmap(plus);
                }

                switch (i.getId()) {
                    case R.id.Top:
                        i.setImageBitmap(top);
                        break;
                    case R.id.Right:
                        i.setImageBitmap(right);
                        break;
                    case R.id.Sign:
                        i.setImageBitmap(minus);
                }
                state = state_none;
            }
        }
                , 900);

        handler.postDelayed(new Runnable()
        {
            public void run() {
                ImageView n = (ImageView) findViewById(R.id.ResultSign);
                n.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.box2));
            }
        }
                , 2000);
    }

    private void end()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Level " + LevelNo + " Finished !");
        alertDialog.setMessage("Good Job !\nYou have Finished Level " + LevelNo + " !");
        alertDialog.setButton("Next", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("LevelNo", ++LevelNo);
                Intent intent = new Intent(getApplicationContext(), Levels_Activity.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
                finish();
            }
        });
        alertDialog.show();
    }
}