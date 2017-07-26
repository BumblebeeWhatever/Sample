package com.android.sample.module.java;

/**
 * Created by hexiaolei on 2017/7/12.
 * Class Function:
 */

public class StringBuilderRunner {

    public static void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("123456");
        System.out.println(sb.deleteCharAt(3));
    }

}
