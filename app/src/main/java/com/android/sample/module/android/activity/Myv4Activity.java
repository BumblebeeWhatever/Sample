package com.android.sample.module.android.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.sample.R;
import com.android.sample.module.android.base.BaseV4Activity;
import com.android.sample.module.android.fragment.V4_DialogFragment;
import com.android.sample.module.android.fragment.helper.FragmentHelper;
import com.android.sample.module.android.utils.Constants;
import com.android.sample.module.android.utils.SampleUtils;

/**
 * Created by hexiaolei on 2017/7/28.
 */

public class Myv4Activity extends BaseV4Activity {

    private View mContainer = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_v4);
        SampleUtils.initToolbar(this);
        mContainer = findViewById(R.id.framelayout);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.Fragment.CONTENT, "第一个fragment");

//        FragmentHelper.showSupportFragment(Myv4Activity.this, V4_1Fragment.class, "hxl");//无效
//        FragmentHelper.showSupportDialogFragment(Myv4Activity.this, V4_DialogFragment.class, "hxl");//有效

//        FragmentHelper.showSupportFragment(Myv4Activity.this, V4_1Fragment.class, mContainer.getId(), bundle);//有效
        FragmentHelper.showSupportDialogFragment(Myv4Activity.this, V4_DialogFragment.class, mContainer.getId());//有效

//        FragmentHelper.showSupportFragment(Myv4Activity.this, V4_1Fragment.class, mContainer.getId(), "hxl");//有效
//        FragmentHelper.showSupportDialogFragment(Myv4Activity.this, V4_DialogFragment.class, mContainer.getId(), "hxl");//有效

    }

}
