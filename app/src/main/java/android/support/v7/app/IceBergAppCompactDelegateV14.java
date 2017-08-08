package android.support.v7.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;

/**
 * Created by luojiani on 17/1/13.
 */
public class IceBergAppCompactDelegateV14 extends AppCompatDelegateImplV14 {
    public IceBergAppCompactDelegateV14(Context context, Window window, AppCompatCallback callback) {
        super(context, window, callback);
    }

    @Override
    public View createView(View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        View view = super.createView(parent, name, context, attrs);
//        Log.d("hxl", "parent:" + parent + ",name:" + name + ",view:" + view);
        return view;
    }

    @Override
    View callActivityOnCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return null;
    }
}
