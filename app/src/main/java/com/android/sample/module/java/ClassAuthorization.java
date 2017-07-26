package com.android.sample.module.java;

/**
 * Created by hexiaolei on 2017/7/4.
 * Class Function:
 */

public class ClassAuthorization {

    /**
     * 外部类能访问内部类的私有构造器
     */
    private class InnerClass {

        private InnerClass() {

        }

        private InnerClass(int i) {

        }

        private void doSomething() {

        }

        private int a;

    }

}
