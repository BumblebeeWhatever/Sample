package com.android.sample.module.android;

import android.accessibilityservice.AccessibilityService;
import android.os.Handler;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

/**
 * Created by hexiaolei on 2017/7/24.
 */

public class MyAccessibilityService extends AccessibilityService {

    boolean goOn = true;

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d("hxl", "onServiceConnected");
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (!goOn) {
            return;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                handlerEvent(event);
            }
        }, 2500);

        if (goOn) {
            goOn = false;
        }
    }

    private void handlerEvent(AccessibilityEvent event) {
        Log.d("hxl", "AccessibilityEvent:" + event.toString());
//        Logger.d("hxl", "source:" + event.getSource());
//        Logger.d("hxl", "getRootInActiveWindow:" + getRootInActiveWindow());
        AccessibilityNodeInfo accessibilityNodeInfo = getRootInActiveWindow();
        if (accessibilityNodeInfo == null) {
            Log.d("hxl", "accessibilityNodeInfo==null");
            return;
        }

        //id
        String idStr = accessibilityNodeInfo.getPackageName() + ":id/horizontalScrollView";//event.getPackageName()==null,why?
        List<AccessibilityNodeInfo> idList = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(idStr);
        Log.d("hxl", "idList size:" + idList.size() + ",idStr:" + idStr);
        if (idList != null && idList.size() > 0) {
            for (int i = 0; i < idList.size(); i++) {
                Log.d("hxl", "item,AccessibilityNodeInfo,i" + i + "," + idList.get(i));
//                idList.get(i).performAction(AccessibilityNodeInfo.ACTION_SCROLL_FORWARD);
                idList.get(i).performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }

        //text
        List<AccessibilityNodeInfo> textList = accessibilityNodeInfo.findAccessibilityNodeInfosByText("horizontalScrollView");
        Log.d("hxl", "textList size:" + textList.size());
        if (textList != null && textList.size() > 0) {
            for (int i = 0; i < textList.size(); i++) {
                Log.d("hxl", "item,AccessibilityNodeInfo,i" + i + "," + textList.get(i));
                textList.get(i).performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }
    }

    /**
     * FIXME android N
     * {@see https://stackoverflow.com/questions/29161195/android-accessibility-edit-all-touch-events}
     * {@see https://stackoverflow.com/questions/38215573/is-there-any-way-to-fire-a-touch-event-with-an-android-accessibility-service}
     */
    private void doDispatchGesture() {
//        Path path = new Path();
//        path.lineTo(100, 0);
//        GestureDescription.StrokeDescription strokeDescription =
//                new GestureDescription.StrokeDescription(path, System.currentTimeMillis(), 50);
//        GestureDescription gestureDescription = new GestureDescription.Builder().addStroke(strokeDescription).build();
//        dispatchGesture(gestureDescription, new GestureResultCallback() {
//            @Override
//            public void onCompleted(GestureDescription gestureDescription) {
//                super.onCompleted(gestureDescription);
//                Logger.d("hxl", "onCompleted");
//            }
//
//            @Override
//            public void onCancelled(GestureDescription gestureDescription) {
//                super.onCancelled(gestureDescription);
//                Logger.d("hxl", "onCancelled");
//            }
//        }, null);
    }

    @Override
    public void onInterrupt() {
        Log.d("hxl", "onInterrupt");
    }

}
