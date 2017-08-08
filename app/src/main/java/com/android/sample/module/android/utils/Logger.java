package com.android.sample.module.android.utils;

import android.util.Log;

/**
 * Created by hexiaolei on 2017/7/28.
 * FIXME 怎么才能优雅的解决静态方法写log，现在都是绑定实例的;
 */

public class Logger {

    private String TAG = "";
    private String mForeAppend = "";

    private Logger(String tag, String append) {
        if (tag == null) {
            tag = "";
        }
        this.TAG = tag;
        if (append == null) {
            append = "";
        }
        this.mForeAppend = append + "_";
    }

    public static Logger instance(String tag, Object append) {
        return new Logger(tag, append.getClass().getSimpleName() + append.hashCode());
    }

    public Logger setTAG(String tag) {
        if (tag == null) {
            tag = "";
        }
        this.TAG = tag;
        return this;
    }

    public Logger setAppend(String append) {
        if (append == null) {
            append = "";
        }
        this.mForeAppend = append + "_";
        return this;
    }

    public Logger d(String msg) {
        Log.d(TAG, mForeAppend + msg);
        return this;
    }

//    public Logger d(String TAG, String msg) {
//        Log.d(TAG, mForeAppend + msg);
//        return this;
//    }

    public Logger e(String msg) {
        Log.e(TAG, mForeAppend + msg);
        return this;
    }

//    public Logger e(String TAG, String msg) {
//        Log.e(TAG, mForeAppend + msg);
//        return this;
//    }

    public Logger i(String msg) {
        Log.i(TAG, mForeAppend + msg);
        return this;
    }

//    public Logger i(String TAG, String msg) {
//        Log.i(TAG, mForeAppend + msg);
//        return this;
//    }

    public Logger v(String msg) {
        Log.v(TAG, mForeAppend + msg);
        return this;
    }

//    public Logger v(String TAG, String msg) {
//        Log.v(TAG, mForeAppend + msg);
//        return this;
//    }

    public Logger w(String msg) {
        Log.w(TAG, mForeAppend + msg);
        return this;
    }

//    public Logger w(String TAG, String msg) {
//        Log.w(TAG, mForeAppend + msg);
//        return this;
//    }

    public static Exception instanceNullException(String parameter) {
        return new Exception("illegal parameter:" + parameter + " which should not be null.");
    }

}
