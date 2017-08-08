package com.android.sample;

import com.google.gson.JsonObject;

/**
 * Created by hexiaolei on 2017/7/4.
 */

public class JavaDoor {

    public static void main(String[] args) {
//        ChessMate.mate();

//        CaseOOM.trigerOOM();

//        StringBuilderRunner.run();

//        System.out.println(null + "_");

        try {
            JsonObject jsonObject = new JsonObject();
            Number a = null;
            jsonObject.addProperty("a", a);
            System.out.println(jsonObject.has("a") + "," + jsonObject.get("a").toString());

            String number = "71.0";
            System.out.println(Double.valueOf(number));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
