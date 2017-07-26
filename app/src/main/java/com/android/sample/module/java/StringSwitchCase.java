package com.android.sample.module.java;

/**
 * Created by hexiaolei on 2017/7/4.
 * Class Function:
 */

public class StringSwitchCase {

    private void runSample() {
        String variate = "abc";
        switch (variate) {
            case "a":
                System.out.println("a");
                break;
            case "b":
                System.out.println("b");
                break;
            case "abC":
                System.out.println("abC");
            case "abc":
                System.out.println("abc");
                break;
        }
    }


}
