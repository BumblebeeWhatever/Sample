package com.android.sample.module.android;

import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsListView;

import java.lang.reflect.Field;

/**
 * Created by hexiaolei on 2017/7/5.
 * Class Function:
 */

public class Reflect {

    private static String TAG = "hxl";

    public static void getListViewListenerState(AbsListView listView) {
        try {
            Class temp = listView.getClass();
            Log.d(TAG, "temp:" + temp);
            while (!TextUtils.equals(temp.getName(), AbsListView.class.getName())) {//FIXME 为什么一定要超类？子类字节码中并没有这个属性？
                temp = temp.getSuperclass();
                Log.d(TAG, "temp:" + temp);
            }
            Field delegateFiled = temp.getDeclaredField("mOnScrollListener");
            delegateFiled.setAccessible(true);
            Object delegateListener = delegateFiled.get(listView);
            Log.d(TAG, "Reflect delegateListener:" + delegateListener);
        } catch (Exception e) {
            Log.d(TAG, "Reflect error");
            e.printStackTrace();
        }
    }

}
