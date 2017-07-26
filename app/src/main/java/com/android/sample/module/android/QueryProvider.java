package com.android.sample.module.android;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

/**
 * Created by hexiaolei on 2017/7/4.
 * Class Function:
 */

public class QueryProvider {

    private static String TAG = "hxl";

    private void resolveProvider(Context ctx) {
        Log.d(TAG, "resolveProvider");
//        Cursor cursor = null;
//        try {
//            Uri uri = Uri.parse("content://com.meituan.common.analyse.demo.OneIdProvider/query_local_id");
//            cursor = getContentResolver().query(uri, null, null, null, null);
//            if (cursor != null && cursor.getCount() > 0) {
//                cursor.moveToFirst();
//                String localId = cursor.getString(0);
//                Log.d(TAG,"resolveProvider,localId:"+localId);
//
//            }
//        } catch (Exception e) {
//            Log.d(TAG, "getLocalIdByProvider1 is error:" + e.getMessage());
//        } finally {
//            if (cursor != null && !cursor.isClosed()) {
//                cursor.close();
//            }
//        }

        Cursor cursor2 = null;
        try {
            Uri uri = Uri.parse("content://com.meituan.android_unionid.OneIdProvider/query");
            cursor2 = ctx.getContentResolver().query(uri, null, null, null, null);
            if (cursor2 != null && cursor2.getCount() > 0) {
                cursor2.moveToFirst();
                String localId = cursor2.getString(0);
                Log.d(TAG, "resolveProvider,oneId:" + localId);

            }
        } catch (Exception e) {
            Log.d(TAG, "getLocalIdByProvider2 is error:" + e.getMessage());
        } finally {
            if (cursor2 != null && !cursor2.isClosed()) {
                cursor2.close();
            }
        }
    }

}
