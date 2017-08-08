package com.android.sample.module.android.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.sample.R;
import com.android.sample.module.android.base.BaseAppActivity;
import com.android.sample.module.android.fragment.App_DialogFragment;
import com.android.sample.module.android.fragment.helper.FragmentHelper;

/**
 * Created by hexiaolei on 2017/7/28.
 */

public class MyAppActivity extends BaseAppActivity {


    private View mContainer = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_app);
//        SampleUtils.initToolbar(this);
        mContainer = findViewById(R.id.framelayout);

//        FragmentHelper.showAppFragment(MyAppActivity.this, App_1Fragment.class, "hxl");//无效
//        FragmentHelper.showAppDialogFragment(MyAppActivity.this, App_DialogFragment.class, "hxl");//有效

//        FragmentHelper.showAppFragment(MyAppActivity.this, App_1Fragment.class, mContainer.getId());//有效
//        FragmentHelper.showAppDialogFragment(MyAppActivity.this, App_DialogFragment.class, mContainer.getId());//有效

//        FragmentHelper.showAppFragment(MyAppActivity.this, App_1Fragment.class, mContainer.getId(), "hxl");//有效
        FragmentHelper.showAppDialogFragment(MyAppActivity.this, App_DialogFragment.class, mContainer.getId(), "hxl");//有效

    }

}
