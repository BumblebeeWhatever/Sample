package com.android.sample.module.android.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.sample.module.android.utils.Logger;

/**
 * Created by hexiaolei on 2017/7/28.
 */

public class BaseAppDialogFragment extends android.app.DialogFragment {

    protected Logger Log = Logger.instance("hxl", this);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("onActivityCreated");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("onSaveInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d("onLowMemory");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d("onCreateDialog");
        return super.onCreateDialog(savedInstanceState);
    }
}
