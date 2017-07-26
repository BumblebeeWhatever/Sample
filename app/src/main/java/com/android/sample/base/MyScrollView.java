package com.android.sample.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by hexiaolei on 2017/7/25.
 */

public class MyScrollView extends ScrollView {

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
//        Log.d("hxl", "MyScrollView computeScroll");
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
//        Log.d("hxl", "MyScrollView scrollTo");
    }
}
