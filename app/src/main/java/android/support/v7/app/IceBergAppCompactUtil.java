package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.Window;

/**
 * Created by luojiani on 17/1/13.
 */

public final class IceBergAppCompactUtil {
    private IceBergAppCompactUtil() {

    }

    /**
     * Create a {@link android.support.v7.app.AppCompatDelegate} to use with {@code activity}.
     *
     * @param callback An optional callback for AppCompat specific events
     */
    public static AppCompatDelegate create(Activity activity, AppCompatCallback callback) {
        return create(activity, activity.getWindow(), callback);
    }

    /**
     * Create a {@link android.support.v7.app.AppCompatDelegate} to use with {@code dialog}.
     *
     * @param callback An optional callback for AppCompat specific events
     */
    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback callback) {
        return create(dialog.getContext(), dialog.getWindow(), callback);
    }

    public static AppCompatDelegate create(Context context, Window window,
                                           AppCompatCallback callback) {
        final int sdk = Build.VERSION.SDK_INT;
        if (sdk >= Build.VERSION_CODES.M) {
            return new IceBergAppCompactDelegateV23(context, window, callback);
        } else if (sdk >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            return new IceBergAppCompactDelegateV14(context, window, callback);
        } else {
            return new AppCompatDelegateImplV11(context, window, callback);
        }
    }
}
