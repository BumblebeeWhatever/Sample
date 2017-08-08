package com.android.sample.module.android.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.sample.R;
import com.android.sample.module.android.base.BaseAppFragment;
import com.android.sample.module.android.fragment.helper.FragmentHelper;
import static com.android.sample.module.android.utils.Constants.Fragment.CONTAINER_ID;

/**
 * Created by hexiaolei on 2017/7/28.
 */

public class App_1Fragment extends BaseAppFragment {

    private Button mBtn;
    private int mContainerId;

    @SuppressLint("ValidFragment")
    public App_1Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.layout_fragment_v4_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtn = (Button) view.findViewById(R.id.click);
        if (getArguments() != null) {
            mContainerId = getArguments().getInt(CONTAINER_ID);
        }
        mBtn.setOnClickListener((v) -> {
            FragmentHelper.showAppDialogFragment(getActivity(), App_DialogFragment.class, "hxl");
        });
    }

}
