package com.android.sample.module.android.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.IceBergAppCompactUtil;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.android.sample.module.android.utils.Logger;

/**
 * Created by hexiaolei on 2017/7/28.
 * 兼容包Activity基类，提供生命周期log功能
 * 其主要可提供v4包下的FragmentActivity、v7下的AppCompatActivity功能
 */

public class BaseV4Activity extends AppCompatActivity {

    private static AppCompatDelegate mDelegate = null;
    protected Logger Log = Logger.instance("hxl", this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("onCreate");
    }

    @Override
    public void recreate() {
        super.recreate();
        Log.d("recreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy");
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("onPostResume");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d("onLowMemory");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("onNewIntent");
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        Log.d("onResumeFragments");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.d("onAttachFragment");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("onWindowFocusChanged,hasFocus:" + hasFocus);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("onAttachedToWindow");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("onDetachedFromWindow");
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
//        Log.d("dispatchKeyEvent");
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.d("dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        return mDelegate == null ? (mDelegate = IceBergAppCompactUtil.create(this, this.getWindow(), this)) : mDelegate;
    }

}
