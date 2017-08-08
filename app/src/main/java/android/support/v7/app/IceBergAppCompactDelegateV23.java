package android.support.v7.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;

/**
 * Created by luojiani on 17/1/13.
 */
public class IceBergAppCompactDelegateV23 extends AppCompatDelegateImplV23 {
    public IceBergAppCompactDelegateV23(Context context, Window window, AppCompatCallback callback) {
        super(context, window, callback);
    }


    /**
     * inflate xml时 从根节点开始向下遍历
     *
     * @param parent  父容器 可为null
     * @param name    本次创建的子View名
     * @param context
     * @param attrs
     * @return
     */
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
