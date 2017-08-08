package com.android.sample;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * Created by hexiaolei on 2017/7/4.
 * Class Function:
 */

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
