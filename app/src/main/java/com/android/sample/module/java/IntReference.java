package com.android.sample.module.java;

import static com.android.sample.module.java.IntReference.Reference.getNum;

/**
 * Created by hexiaolei on 2017/7/26.
 * 这个返回什么？
 */

public class IntReference {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        System.out.println(getNum());
        ++num;
        System.out.println(getNum());
        ++num;
        System.out.println(getNum());
    }

    static int num = 0;

    static class Reference {
        static int getNum() {
            return num;
        }
    }

    static Reference reference = new Reference();

}
