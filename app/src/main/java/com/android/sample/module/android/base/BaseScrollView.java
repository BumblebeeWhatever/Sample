package com.android.sample.module.android.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by hexiaolei on 2017/7/25.
 */

public class BaseScrollView extends ScrollView {

    public BaseScrollView(Context context) {
        super(context);
    }

    public BaseScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
//        Logger.d("hxl", "MyScrollView computeScroll");
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
//        Logger.d("hxl", "MyScrollView scrollTo");
    }
}
