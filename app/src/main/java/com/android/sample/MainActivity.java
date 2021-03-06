package com.android.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.android.sample.module.android.ViewIdCollector;
import com.android.sample.module.android.activity.LifePrinterActivity;
import com.android.sample.module.android.activity.MyAppActivity;
import com.android.sample.module.android.activity.Myv4Activity;
import com.android.sample.module.android.activity.WebViewActivity;
import com.android.sample.module.android.utils.SampleUtils;
import com.meituan.android.yoda.YodaConfirm;
import com.meituan.android.yoda.YodaResponseListener;
import com.meituan.android.yoda.plugins.FingerPrintHook;
import com.meituan.android.yoda.plugins.YodaPlugins;
import com.meituan.android.yoda.retrofit.Error;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private static String TAG = "hxl";

    private HorizontalScrollView mHorizontalScrollView = null;

    private Button mImageView = null;

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    private ImageView mTouchIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_main);
        SampleUtils.initToolbar(this);

        inflate();
        initEvent();

//        startAppActivity();
//        startV4Activity();
//        Toast.makeText(getApplicationContext(), "1234456", Toast.LENGTH_SHORT).show();

        initYoda();
    }

    private void inflate() {
        findViewById(R.id.parent).getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() {
            @Override
            public void onGlobalFocusChanged(View oldFocus, View newFocus) {
//                Logger.d("hxl", "oldFocus:" + oldFocus + ",newFocus:" + newFocus);
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
        mButton2.setOnClickListener(mListener);
        mButton3.setOnClickListener(mListener);
    }

    private View.OnClickListener mListener = v -> {
        switch (v.getId()) {
            case R.id.btn_1:
                startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(MainActivity.this, LifePrinterActivity.class));
                break;
            case R.id.btn_3:
                ViewIdCollector.printId(findViewById(R.id.parent));
                break;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
    }

    private Handler mHandler = new Handler();

    private void startAppActivity() {
        startActivity(new Intent(MainActivity.this, MyAppActivity.class));
    }

    private void startV4Activity() {
        startActivity(new Intent(MainActivity.this, Myv4Activity.class));
    }

    private void initYoda() {
        YodaPlugins.getInstance().registerFingerPrintHook(new FingerPrintHook() {
            @Override
            public String requestfingerPrint() {
                return "test";
            }
        });
        YodaConfirm.getInstance(this, new YodaResponseListener() {
            @Override
            public void onYodaResponse(String s, String s1) {

            }

            @Override
            public void onCancel(String s) {

            }

            @Override
            public void onError(String s, Error error) {

            }
        }).startConfirm("123");
    }

}
