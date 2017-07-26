package com.android.sample.module.java;

/**
 * Created by hexiaolei on 2017/7/4.
 * Class Function:
 */

public class Enum {

    enum SCType {
        S, A
    }

    void test(SCType type) {
        switch (type) {
            case S:
                break;
            case A:
                break;
        }
    }

}
