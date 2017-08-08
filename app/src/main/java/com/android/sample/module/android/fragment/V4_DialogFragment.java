package com.android.sample.module.android.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.sample.R;
import com.android.sample.module.android.base.BaseV4DialogFragment;
import com.android.sample.module.android.fragment.helper.FragmentHelper;

import static com.android.sample.module.android.utils.Constants.Fragment.CONTAINER_ID;
import static com.android.sample.module.android.utils.Constants.Fragment.CONTENT;

/**
 * Created by hexiaolei on 2017/7/28.
 */

public class V4_DialogFragment extends BaseV4DialogFragment {

    private TextView mTextView;

    @SuppressLint("ValidFragment")
    public V4_DialogFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.layout_fragment_v4_2, container, false);
        mTextView = (TextView) v.findViewById(R.id.textView);
        final int containerId = getArguments().getInt(CONTAINER_ID);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(CONTENT, "第二个dialogfragment");
                FragmentHelper.showSupportDialogFragment(getActivity(), V4_DialogFragment.class, containerId, bundle);
            }
        });
        String content = getArguments() == null ? null : getArguments().getString(CONTENT);
        if (content != null) {
            mTextView.setText(content);
        }
        return v;
    }

}
