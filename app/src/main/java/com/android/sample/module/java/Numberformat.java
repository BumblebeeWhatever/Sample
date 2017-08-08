package com.android.sample.module.java;

/**
 * Created by hexiaolei on 2017/8/4.
 * 对于string类型转换int型
 */

public class Numberformat {

    public static void main(String[] args) {

        String number = "10";
        System.out.println(Integer.parseInt(number));//ok

//        number = "10.0";
//        System.out.println(Integer.parseInt(number));//NumberFormatException

        System.out.println((int) Double.parseDouble(number));//ok
    }

}
