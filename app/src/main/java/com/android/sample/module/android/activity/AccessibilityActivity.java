package com.android.sample.module.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.android.sample.R;
import com.android.sample.module.android.ViewIdCollector;
import com.android.sample.utils.SampleUtils;

public class AccessibilityActivity extends AppCompatActivity {

    private Context mContext;
    private static String TAG = "hxl";

    private HorizontalScrollView mHorizontalScrollView = null;

    private Button mImageView = null;

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    private int[] position = new int[2];

    private ImageView mTouchIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.layout_activity_accessibility);
        SampleUtils.initToolbar(this);

        inflate();
        initEvent();
    }

    private void inflate() {
        findViewById(R.id.parent).getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
                Log.d("hxl", "oldFocus:" + oldFocus + ",newFocus:" + newFocus);
            }
        });
        mHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);
        mHorizontalScrollView.setSmoothScrollingEnabled(true);

        mButton1 = (Button) findViewById(R.id.btn_1);
        mButton2 = (Button) findViewById(R.id.btn_2);
        mButton3 = (Button) findViewById(R.id.btn_3);
        mImageView = (Button) findViewById(R.id.sample_iv0);

        mTouchIV = (ImageView) findViewById(R.id.touch_iv);
    }

    private void initEvent() {
        mButton1.setOnClickListener(mListener);
//        mButton2.setOnClickListener(mListener);
//        mButton2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("hxl", "click btn2");
//            }
//        });
//        mButton3.setOnClickListener(mListener);

        //在触摸屏上使用时InputDevice.SOURCE_TOUCHSCREEN
        mButton3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                Log.d("hxl", "onTouch:" + event + ",source:" + event.getSource());
                return false;
            }
        });

        mImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("hxl", "touch imageview,event:" + event);
                return false;
            }
        });
//        mImageView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                Log.d("hxl", "imageview onScrollChange,scrollX:" + scrollX + ",oldScrollX:" + oldScrollX);
//            }
//        });

//        Log.d(TAG, "debug?" + BuildConfig.DEBUG);

        mHorizontalScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("hxl", "mHorizontalScrollView onTouch,x:" + event.getRawX() + ",y:" + event.getRawY());
                return false;
            }
        });


        mTouchIV.setOnTouchListener(new View.OnTouchListener() {

            private int originX;
            private float touchStartX;
            RelativeLayout.LayoutParams layoutParams;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getSource() == InputDevice.SOURCE_UNKNOWN ||
                        (event.getPointerCount() > 0 && event.getToolType(0) == MotionEvent.TOOL_TYPE_UNKNOWN)) {
                    //验证在Accessibility不会触发onTouchEvent，但adb shell input swipe命令可以触发，所以有作弊的风险，以此条件防御作弊
                    Log.d("hxl", "Fraud event,not accepted");
                    return true;
                }

                Log.d("hxl", "mTouchIV onTouch,event:" + event);
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    layoutParams = ((RelativeLayout.LayoutParams) mTouchIV.getLayoutParams());
                    originX = layoutParams.leftMargin;
                    touchStartX = event.getRawX();
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    layoutParams.leftMargin = (int) (event.getRawX() - touchStartX + originX);
                    mTouchIV.setLayoutParams(layoutParams);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    layoutParams.leftMargin = originX;
                    mTouchIV.setLayoutParams(layoutParams);
                }
                return false;
            }
        });
    }

    private View.OnClickListener mListener = v -> {
        switch (v.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(AccessibilityActivity.this, WebViewActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(AccessibilityActivity.this, LifePrinterActivity.class));
                break;
            case R.id.btn_3:
                ViewIdCollector.printId(findViewById(R.id.parent));
                break;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
//        mHandler.postDelayed(() -> {
//            mImageView.getLocationInWindow(position);
//            Log.d(TAG, "onResume,delay 1000,x:" + position[0]);
//        }, 1000);
//        mHandler.postDelayed(() -> {
//            mImageView.getLocationInWindow(position);
//            Log.d(TAG, "onResume,delay 4000,x:" + position[0]);
//        }, 4000);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mTouchIV.getLocationInWindow(position);
                Log.d("hxl", "x:" + position[0] + ",y:" + position[1]);
            }
        }, 100);
    }

    private Handler mHandler = new Handler();

}
