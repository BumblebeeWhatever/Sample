package com.android.sample.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.android.sample.R;

/**
 * Created by hexiaolei on 2017/7/25.
 */

public class MyButton extends AppCompatButton {

    private String TAG = "hxl";
    private String mPreStr = null;

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.LOGPRE);
        if (typedArray != null) {
            mPreStr = typedArray.getString(R.styleable.LOGPRE_log_pre);
            typedArray.recycle();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Log.d(TAG, this + mPreStr + " onTouchEvent,event:" + event + ",source:" + event.getSource());
        return super.onTouchEvent(event);
    }

    @Override
    public boolean performClick() {
//        Log.d(TAG, mPreStr + " performClick");
        return super.performClick();
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
//        Log.d(TAG, mPreStr + " onTrackballEvent");
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
//        Log.d(TAG, mPreStr + " onKeyShortcut");
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
//        Log.d(TAG, mPreStr + " dispatchKeyEventPreIme");
        return super.dispatchKeyEventPreIme(event);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d("hxl", mPreStr + " dispatchKeyEvent,source:" + event.getSource());
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
//        Log.d(TAG, mPreStr + " dispatchKeyShortcutEvent");
        return super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean fraud = event != null && event.getPointerCount() > 0 && event.getToolType(0) == MotionEvent.TOOL_TYPE_UNKNOWN;
        Log.d("hxl", mPreStr + " dispatchTouchEvent,fraud:" + fraud);
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
//        Log.d(TAG, mPreStr + " onHoverEvent");
        return super.onHoverEvent(event);
    }

    @Override
    public String toString() {
        return TextUtils.isEmpty(mPreStr) ? super.toString() : mPreStr;
    }
}
