package com.ahmedemad.matchsticks;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by ahmadbarakat on 248 / 5 / 14.
 */
public class GridAdapter extends BaseAdapter{

    private Context mContext;
    //private SharedPreferences sharedpreferences;
    private int LastLevel;

    public GridAdapter(Context c, int last) {
        mContext = c;
        LastLevel = last;
    }

    public void setLastlevel(int last)
    {
        LastLevel = last;
        notifyDataSetChanged();
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;

        //Log.e("Adapter", "Last Level = " + lastlevel);
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }

        if ((position+1) <= LastLevel)
            imageView.setImageResource(mThumbIdsTrue[position]);
        else if ((position+1) == LastLevel+1)
            imageView.setImageResource(mThumbIds[position]);
        else
            imageView.setImageResource(mThumbIdsFalse[position]);
        return imageView;
    }

    private Integer[] mThumbIds = {
            R.drawable.l1,
            R.drawable.l2,
            R.drawable.l3,
            R.drawable.l4,
            R.drawable.l5,
            R.drawable.l6,
            R.drawable.l7,
            R.drawable.l8,
            R.drawable.l9,
            R.drawable.l10,
            R.drawable.l11,
            R.drawable.l12,
            R.drawable.l13,
            R.drawable.l14,
            R.drawable.l15,
            R.drawable.l16,
            R.drawable.l17,
            R.drawable.l18,
            R.drawable.l19,
            R.drawable.l20,
            R.drawable.l21,
            R.drawable.l22,
            R.drawable.l23,
            R.drawable.l24,
            R.drawable.l25,
            R.drawable.l26,
            R.drawable.l27,
            R.drawable.l28,
            R.drawable.l29,
            R.drawable.l30,
            R.drawable.l31,
            R.drawable.l32,
            R.drawable.l33,
            R.drawable.l34,
            R.drawable.l35,
            R.drawable.l36,
            R.drawable.l37,
            R.drawable.l38,
            R.drawable.l39,
            R.drawable.l40,
            R.drawable.l41,
            R.drawable.l42,
            R.drawable.l43,
            R.drawable.l44,
            R.drawable.l45,
            R.drawable.l46,
            R.drawable.l47,
            R.drawable.l48,
            R.drawable.l49,
            R.drawable.l50
    };

    private Integer[] mThumbIdsTrue = {
            R.drawable.l1_true,
            R.drawable.l2_true,
            R.drawable.l3_true,
            R.drawable.l4_true,
            R.drawable.l5_true,
            R.drawable.l6_true,
            R.drawable.l7_true,
            R.drawable.l8_true,
            R.drawable.l9_true,
            R.drawable.l10_true,
            R.drawable.l11_true,
            R.drawable.l12_true,
            R.drawable.l13_true,
            R.drawable.l14_true,
            R.drawable.l15_true,
            R.drawable.l16_true,
            R.drawable.l17_true,
            R.drawable.l18_true,
            R.drawable.l19_true,
            R.drawable.l20_true,
            R.drawable.l21_true,
            R.drawable.l22_true,
            R.drawable.l23_true,
            R.drawable.l24_true,
            R.drawable.l25_true,
            R.drawable.l26_true,
            R.drawable.l27_true,
            R.drawable.l28_true,
            R.drawable.l29_true,
            R.drawable.l30_true,
            R.drawable.l31_true,
            R.drawable.l32_true,
            R.drawable.l33_true,
            R.drawable.l34_true,
            R.drawable.l35_true,
            R.drawable.l36_true,
            R.drawable.l37_true,
            R.drawable.l38_true,
            R.drawable.l39_true,
            R.drawable.l40_true,
            R.drawable.l41_true,
            R.drawable.l42_true,
            R.drawable.l43_true,
            R.drawable.l44_true,
            R.drawable.l45_true,
            R.drawable.l46_true,
            R.drawable.l47_true,
            R.drawable.l48_true,
            R.drawable.l49_true,
            R.drawable.l50_true
    };

    private Integer[] mThumbIdsFalse = {
            R.drawable.l1_false,
            R.drawable.l2_false,
            R.drawable.l3_false,
            R.drawable.l4_false,
            R.drawable.l5_false,
            R.drawable.l6_false,
            R.drawable.l7_false,
            R.drawable.l8_false,
            R.drawable.l9_false,
            R.drawable.l10_false,
            R.drawable.l11_false,
            R.drawable.l12_false,
            R.drawable.l13_false,
            R.drawable.l14_false,
            R.drawable.l15_false,
            R.drawable.l16_false,
            R.drawable.l17_false,
            R.drawable.l18_false,
            R.drawable.l19_false,
            R.drawable.l20_false,
            R.drawable.l21_false,
            R.drawable.l22_false,
            R.drawable.l23_false,
            R.drawable.l24_false,
            R.drawable.l25_false,
            R.drawable.l26_false,
            R.drawable.l27_false,
            R.drawable.l28_false,
            R.drawable.l29_false,
            R.drawable.l30_false,
            R.drawable.l31_false,
            R.drawable.l32_false,
            R.drawable.l33_false,
            R.drawable.l34_false,
            R.drawable.l35_false,
            R.drawable.l36_false,
            R.drawable.l37_false,
            R.drawable.l38_false,
            R.drawable.l39_false,
            R.drawable.l40_false,
            R.drawable.l41_false,
            R.drawable.l42_false,
            R.drawable.l43_false,
            R.drawable.l44_false,
            R.drawable.l45_false,
            R.drawable.l46_false,
            R.drawable.l47_false,
            R.drawable.l48_false,
            R.drawable.l49_false,
            R.drawable.l50_false
    };
}
