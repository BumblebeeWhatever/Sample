package com.android.sample.module.java;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.NewThreadScheduler;

/**
 * Created by hexiaolei on 2017/7/4.
 * Class Function:
 */

public class RX {

    private static String TAG = "hxl";

    private static void rxAndroid() {
        Observable.just("1", "2").subscribeOn(new NewThreadScheduler()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG, "onNext,s:" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        });
    }

}
