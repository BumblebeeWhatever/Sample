package android.view;

import android.content.Context;

/**
 * Created by hexiaolei on 2017/7/4.
 * Class Function:
 */

public class ViewHelper {

    public String getProtectedField(Context ctx) {
        return new View(ctx).VIEW_LOG_TAG;
    }

}
