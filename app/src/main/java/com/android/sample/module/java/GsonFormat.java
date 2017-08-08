package com.android.sample.module.java;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by hexiaolei on 2017/8/4.
 * GSON解析string的过程中
 * 如果把data改为Map<String, Object>，可以解析成功，但是为Map<String, String>则解析失败
 */

public class GsonFormat {

    static class YodaResult implements Serializable {

        public int status;
//        public Map<String, String> data;//解析失败
        public Map<String, Object> data;//解析成功
        public Error error;

        @Override
        public String toString() {
            return new StringBuilder("YodaResult{status=").append(status).append(", data=").append(data)
                    .append(", error=").append(error).append('}').toString();
        }

    }

    public static void main(String[] args) {
        try {
            String str = "{'status':1,'data':{'pro':{'mobile':'1222222'}},'error':null}";
            System.out.println(new Gson().fromJson(str, YodaResult.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
