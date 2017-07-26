package com.android.sample.module.android;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by hexiaolei on 2017/7/11.
 * Class Function:
 */

public class Retrofit {

    static OkHttpClient.Builder client = null;

    static retrofit2.Retrofit retrofit = null;

    static {
        client = new OkHttpClient.Builder();
    }

    public static void run() {
        retrofit = new retrofit2.Retrofit.Builder().client(client.build()).baseUrl("").build();
    }

    public static void addIntecepter(Interceptor interceptor) {
        client.addInterceptor(interceptor);
    }

    public static void addNetworkInterceptor(Interceptor interceptor) {
        client.addNetworkInterceptor(interceptor);
    }

}
