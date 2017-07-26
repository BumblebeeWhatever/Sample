package com.android.sample.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by hexiaolei on 2017/7/25.
 */

public class MyHorizontalScrollView extends HorizontalScrollView {

    public MyHorizontalScrollView(Context context) {
        super(context);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        Log.d("hxl", "MyHorizontalScrollView onTouchEvent,ev:" + ev);
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d("hxl", "MyHorizontalScrollView dispatchTouchEvent,source:" + event.getSource());
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.d("hxl", "MyHorizontalScrollView onInterceptTouchEvent,ev:" + ev);
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean executeKeyEvent(KeyEvent event) {
//        Log.d("hxl", "MyHorizontalScrollView executeKeyEvent,ev:" + event);
        return super.executeKeyEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
//        Log.d("hxl", "MyHorizontalScrollView onGenericMotionEvent,ev:" + event);
        return super.onGenericMotionEvent(event);
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
//        Log.d("hxl", "MyHorizontalScrollView dispatchKeyEventPreIme,ev:" + event);
        return super.dispatchKeyEventPreIme(event);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
//        Log.d("hxl", "MyHorizontalScrollView dispatchKeyShortcutEvent,ev:" + event);
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        Log.d("hxl", "MyHorizontalScrollView dispatchTrackballEvent,ev:" + event);
        return super.dispatchTrackballEvent(event);
    }

    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
//        Log.d("hxl", "MyHorizontalScrollView dispatchHoverEvent,ev:" + event);
        return super.dispatchHoverEvent(event);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
//        Log.d("hxl", "MyHorizontalScrollView onInterceptHoverEvent,ev:" + event);
        return super.onInterceptHoverEvent(event);
    }

    @Override
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
//        Log.d("hxl", "MyHorizontalScrollView dispatchGenericPointerEvent,ev:" + event);
        return super.dispatchGenericPointerEvent(event);
    }

    @Override
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
//        Log.d("hxl", "MyHorizontalScrollView dispatchGenericFocusedEvent,ev:" + event);
        return super.dispatchGenericFocusedEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.d("hxl", "MyHorizontalScrollView dispatchTouchEvent,ev:" + ev);
        boolean fraud = event != null && event.getPointerCount() > 0 && event.getToolType(0) == MotionEvent.TOOL_TYPE_UNKNOWN;
        Log.d("hxl", "MyHorizontalScrollView dispatchTouchEvent,fraud:" + fraud);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
//        Log.d("hxl", "MyHorizontalScrollView onTrackballEvent,ev:" + event);
        return super.onTrackballEvent(event);
    }

}
