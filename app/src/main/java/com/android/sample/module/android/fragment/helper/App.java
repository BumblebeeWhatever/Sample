package com.android.sample.module.android.fragment.helper;

import android.app.Activity;

import com.android.sample.module.android.base.BaseAppDialogFragment;
import com.android.sample.module.android.base.BaseAppFragment;

/**
 * Created by hexiaolei on 2017/7/28.
 * app下的组件
 */

public class App {

    //展示Fragment
    public static void showFragment(Activity activity, Class clazz, String tag) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            activity.getFragmentManager().beginTransaction().add((BaseAppFragment) clazz.newInstance(), tag).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showFragment(Activity activity, Class clazz, int containerId) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            BaseAppFragment dialogFragment = (BaseAppFragment) clazz.newInstance();
            activity.getFragmentManager().beginTransaction().add(containerId, dialogFragment).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showFragment(Activity activity, Class clazz, int containerId, String tag) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            activity.getFragmentManager().beginTransaction().add(containerId, (BaseAppFragment) clazz.newInstance(), tag).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //展示DialogFragment
    public static void showDialogFragment(Activity activity, Class clazz, String tag) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            activity.getFragmentManager().beginTransaction().add((BaseAppDialogFragment) clazz.newInstance(), tag).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDialogFragment(Activity activity, Class clazz, int containerId) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            BaseAppDialogFragment dialogFragment = (BaseAppDialogFragment) clazz.newInstance();
            dialogFragment.setShowsDialog(false);
            activity.getFragmentManager().beginTransaction().add(containerId, dialogFragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDialogFragment(Activity activity, Class clazz, int containerId, String tag) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            activity.getFragmentManager().beginTransaction().add(containerId, (BaseAppDialogFragment) clazz.newInstance(), tag).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
