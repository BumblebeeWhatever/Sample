package com.android.sample.module.java;

import com.google.gson.JsonObject;

/**
 * Created by hexiaolei on 2017/8/4.
 * Gson的JsonObject
 * put一个value为null的值，也是支持的，且contain为true，且转换不会异常
 * 但是put一个key为null的值，会异常
 */

public class GsonJsonObject {

    public static void main(String[] args) {
        try {
            JsonObject jsonObject = new JsonObject();
            Number a = null;
            jsonObject.addProperty("a", a);
            System.out.println(jsonObject.has("a") + "," + jsonObject.get("a").toString());

//            jsonObject.addProperty(null, "b");//NullPointerException
            System.out.println(jsonObject.has(null));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}