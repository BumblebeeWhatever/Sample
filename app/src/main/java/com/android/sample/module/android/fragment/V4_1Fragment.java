package com.android.sample.module.android.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.sample.R;
import com.android.sample.module.android.base.BaseV4Fragment;
import com.android.sample.module.android.fragment.helper.FragmentHelper;

import static android.support.v7.widget.StaggeredGridLayoutManager.TAG;
import static com.android.sample.module.android.utils.Constants.Fragment.CONTAINER_ID;
import static com.android.sample.module.android.utils.Constants.Fragment.CONTENT;

/**
 * Created by hexiaolei on 2017/7/28.
 */

public class V4_1Fragment extends BaseV4Fragment {

    private Button mBtn;
    private int mContainerId;

    @SuppressLint("ValidFragment")
    public V4_1Fragment() {
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
        final Bundle bundle = new Bundle();
        String tag = null;
        if (getArguments() != null) {
            mContainerId = getArguments().getInt(CONTAINER_ID);
            bundle.putInt(CONTAINER_ID, mContainerId);
            String content = getArguments().getString(CONTENT);
            if (content != null) {
                mBtn.setText(content);
            }
            bundle.putString(CONTENT, "第二个dialogfragment");
            tag = getArguments().getString(TAG);
            if (tag != null) {
                bundle.putString(TAG, tag);
            }
        }
        final String finalTAG = tag;
        mBtn.setOnClickListener((v) -> {
//            FragmentHelper.showSupportFragment(getActivity(), V4_1Fragment.class, mContainerId, bundle);
//            FragmentHelper.showSupportDialogFragment(getActivity(), V4_DialogFragment.class, finalTAG);
            FragmentHelper.showSupportDialogFragment(getActivity(), V4_DialogFragment.class, mContainerId);
        });
    }

}
