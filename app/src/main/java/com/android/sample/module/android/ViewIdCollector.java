package com.android.sample.module.android;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hexiaolei on 2017/7/18.
 */

public class ViewIdCollector {

    public static void printId(View v) {
        View view = v;
        Log.d("hxl", "view:" + view + ",id:" + getStringId(view));
        if (v instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) v;
            for (int i = 0; i < parent.getChildCount(); i++) {
                printId(parent.getChildAt(i));
            }
        }
    }

    public static String getStringId(View view) {
        try {
            return view.getResources().getResourceEntryName(view.getId());
        } catch (Exception e) {
            Log.d("hxl", "e:"+e.getMessage());
            return "";
        }
    }

}
