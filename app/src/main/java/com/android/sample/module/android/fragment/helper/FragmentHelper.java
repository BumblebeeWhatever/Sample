package com.android.sample.module.android.fragment.helper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by hexiaolei on 2017/7/28.
 */

public class FragmentHelper {

    //app包
    public static void showAppFragment(Activity activity, Class clazz, String tag) {
        App.showFragment(activity, clazz, tag);
    }

    public static void showAppFragment(Activity activity, Class clazz, int containerId) {
        App.showFragment(activity, clazz, containerId);
    }

    public static void showAppFragment(Activity activity, Class clazz, int containerId, String tag) {
        App.showFragment(activity, clazz, containerId, tag);
    }

    public static void showAppDialogFragment(Activity activity, Class clazz, String tag) {
        App.showDialogFragment(activity, clazz, tag);
    }

    public static void showAppDialogFragment(Activity activity, Class clazz, int containerId) {
        App.showDialogFragment(activity, clazz, containerId);
    }

    public static void showAppDialogFragment(Activity activity, Class clazz, int containerId, String tag) {
        App.showDialogFragment(activity, clazz, containerId, tag);
    }


    //support包
    public static void showSupportFragment(FragmentActivity activity, Class clazz, String tag) {
        Support.showFragment(activity, clazz, tag);
    }

    public static void showSupportFragment(FragmentActivity activity, Class clazz, String tag, Bundle bundle) {
        Support.showFragment(activity, clazz, tag, bundle);
    }

    public static void showSupportFragment(FragmentActivity activity, Class clazz, int containerId) {
        Support.showFragment(activity, clazz, containerId);
    }

    public static void showSupportFragment(FragmentActivity activity, Class clazz, int containerId, Bundle bundle) {
        Support.showFragment(activity, clazz, containerId, bundle);
    }

    public static void showSupportFragment(FragmentActivity activity, Class clazz, int containerId, String tag) {
        Support.showFragment(activity, clazz, containerId, tag);
    }

    public static void showSupportFragment(FragmentActivity activity, Class clazz, int containerId, String tag, Bundle bundle) {
        Support.showFragment(activity, clazz, containerId, tag, bundle);
    }

    public static void showSupportDialogFragment(FragmentActivity activity, Class clazz, String tag) {
        Support.showDialogFragment(activity, clazz, tag);
    }

    public static void showSupportDialogFragment(FragmentActivity activity, Class clazz, String tag, Bundle bundle) {
        Support.showDialogFragment(activity, clazz, tag, bundle);
    }

    public static void showSupportDialogFragment(FragmentActivity activity, Class clazz, int containerId) {
        Support.showDialogFragment(activity, clazz, containerId);
    }

    public static void showSupportDialogFragment(FragmentActivity activity, Class clazz, int containerId, Bundle bundle) {
        Support.showDialogFragment(activity, clazz, containerId, bundle);
    }

    public static void showSupportDialogFragment(FragmentActivity activity, Class clazz, int containerId, String tag) {
        Support.showDialogFragment(activity, clazz, containerId, tag);
    }

    public static void showSupportDialogFragment(FragmentActivity activity, Class clazz, int containerId, String tag, Bundle bundle) {
        Support.showDialogFragment(activity, clazz, containerId, tag, bundle);
    }
}
