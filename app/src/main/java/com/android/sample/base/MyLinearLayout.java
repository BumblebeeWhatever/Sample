package com.android.sample.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by hexiaolei on 2017/7/25.
 */

public class MyLinearLayout extends LinearLayout {

    private String TAG = "hxl";

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        Log.d(TAG, "MyLinearLayout onTouchEvent,ev:" + ev);
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d(TAG, "MyLinearLayout dispatchKeyEvent,ev:" + event);
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "MyLinearLayout onInterceptTouchEvent,ev:" + ev);
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Log.d("hxl", "MyLinearLayout onGenericMotionEvent,ev:" + event);
        return super.onGenericMotionEvent(event);
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        Log.d("hxl", "MyLinearLayout dispatchKeyEventPreIme,ev:" + event);
        return super.dispatchKeyEventPreIme(event);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        Log.d("hxl", "MyLinearLayout dispatchKeyShortcutEvent,ev:" + event);
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        Log.d("hxl", "MyLinearLayout dispatchTrackballEvent,ev:" + event);
        return super.dispatchTrackballEvent(event);
    }

    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        Log.d("hxl", "MyLinearLayout dispatchHoverEvent,ev:" + event);
        return super.dispatchHoverEvent(event);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        Log.d("hxl", "MyLinearLayout onInterceptHoverEvent,ev:" + event);
        return super.onInterceptHoverEvent(event);
    }

    @Override
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        Log.d("hxl", "MyLinearLayout dispatchGenericPointerEvent,ev:" + event);
        return super.dispatchGenericPointerEvent(event);
    }

    @Override
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        Log.d("hxl", "MyLinearLayout dispatchGenericFocusedEvent,ev:" + event);
        return super.dispatchGenericFocusedEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.d("hxl", "MyLinearLayout dispatchTouchEvent,ev:" + ev);
        boolean fraud = event != null && event.getPointerCount() > 0 && event.getToolType(0) == MotionEvent.TOOL_TYPE_UNKNOWN;
        Log.d("hxl", "MyLinearLayout onTouchEvent,fraud:" + fraud);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Log.d("hxl", "MyLinearLayout onTrackballEvent,ev:" + event);
        return super.onTrackballEvent(event);
    }

}
