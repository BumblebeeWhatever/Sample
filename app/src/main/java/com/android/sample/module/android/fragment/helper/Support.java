package com.android.sample.module.android.fragment.helper;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.android.sample.module.android.base.BaseV4DialogFragment;
import com.android.sample.module.android.base.BaseV4Fragment;
import com.android.sample.module.android.utils.Constants;

/**
 * Created by hexiaolei on 2017/7/28.
 * v4/v7包下的组件
 */

public class Support {

    //展示fragment
    public static void showFragment(FragmentActivity activity, Class clazz, String tag) {
        showFragment(activity, clazz, tag, null);
    }

    public static void showFragment(FragmentActivity activity, Class clazz, String tag, Bundle bundle) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            BaseV4Fragment instance = (BaseV4Fragment) clazz.newInstance();
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(Constants.Fragment.TAG, tag);
            instance.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().add(instance, tag).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showFragment(FragmentActivity activity, Class clazz, int containerId) {
        showFragment(activity, clazz, containerId, (Bundle) null);
    }

    public static void showFragment(FragmentActivity activity, Class clazz, int containerId, Bundle bundle) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            BaseV4Fragment bf = (BaseV4Fragment) clazz.newInstance();
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(Constants.Fragment.CONTAINER_ID, containerId);
            bf.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().replace(containerId, bf).commitAllowingStateLoss();
        } catch (Exception e) {
        }
    }

    public static void showFragment(FragmentActivity activity, Class clazz, int containerId, String tag) {
        showFragment(activity, clazz, containerId, tag, null);
    }

    public static void showFragment(FragmentActivity activity, Class clazz, int containerId, String tag, Bundle bundle) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            BaseV4Fragment bf = (BaseV4Fragment) clazz.newInstance();
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(Constants.Fragment.TAG, tag);
            bundle.putInt(Constants.Fragment.CONTAINER_ID, containerId);
            bf.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().add(containerId, bf, tag).commitAllowingStateLoss();
        } catch (Exception e) {
        }
    }


    //展示DialogFragment
    public static void showDialogFragment(FragmentActivity activity, Class clazz, String tag) {
        showDialogFragment(activity, clazz, tag, null);
    }

    public static void showDialogFragment(FragmentActivity activity, Class clazz, String tag, Bundle bundle) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(Constants.Fragment.TAG, tag);
            BaseV4DialogFragment instance = (BaseV4DialogFragment) clazz.newInstance();
            instance.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().add(instance, tag).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDialogFragment(FragmentActivity activity, Class clazz, int containerId) {
        showDialogFragment(activity, clazz, containerId, (Bundle) null);
    }

    public static void showDialogFragment(FragmentActivity activity, Class clazz, int containerId, Bundle bundle) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(Constants.Fragment.CONTAINER_ID, containerId);
            BaseV4DialogFragment dialogFragment = (BaseV4DialogFragment) clazz.newInstance();
            dialogFragment.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().replace(containerId, dialogFragment).addToBackStack(null).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDialogFragment(FragmentActivity activity, Class clazz, int containerId, String tag) {
        showDialogFragment(activity, clazz, containerId, tag, null);
    }

    public static void showDialogFragment(FragmentActivity activity, Class clazz, int containerId, String tag, Bundle bundle) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        try {
            BaseV4DialogFragment bdf = (BaseV4DialogFragment) clazz.newInstance();
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(Constants.Fragment.CONTAINER_ID, containerId);
            bundle.putString(Constants.Fragment.TAG, tag);
            bdf.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction().add(containerId, bdf, tag).commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
