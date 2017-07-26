package com.android.sample.module.android;

import android.view.View;

import com.android.sample.R;

/**
 * Created by hexiaolei on 2017/7/4.
 * Class Function:
 */

public class ViewTag {

    /**
     * 自定义View tag
     * @param view
     */
    public static void saveViewTag(View view){
        int selfTag = (int) Math.pow(2, 25);
        view.setTag(selfTag, "1");
        int value = R.bool.tag_id;
        view.setTag(R.bool.tag_id, "2");
    }

}
