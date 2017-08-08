package com.android.sample.module.android.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.sample.R;
import com.android.sample.module.android.base.BaseAppDialogFragment;

/**
 * Created by hexiaolei on 2017/7/28.
 */

public class App_DialogFragment extends BaseAppDialogFragment {

    @SuppressLint("ValidFragment")
    public App_DialogFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.layout_fragment_v4_2, container, false);
    }


}
