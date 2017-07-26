package com.android.sample.module.java;

import com.android.sample.annotation.Table;

/**
 * Created by hexiaolei on 2017/7/4.
 * Class Function:
 */

public class DeadLock {

    @Table(data = "doTest", num = 2)
    private static void doTest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread start time:" + System.currentTimeMillis());
//                mMap.put("a",getStr());
                System.out.println("child thread end time:" + System.currentTimeMillis());
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread start time:" + System.currentTimeMillis());
//        mMap.put("c","d");
        System.out.println("main thread end time:" + System.currentTimeMillis());
    }

    private static void deadlock() {
        System.out.println("start deadlock");
//        Log.d(TAG,"start deadlock");
        new Thread(new Runnable() {
            @Override
            public void run() {
                method1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                method2();
            }
        }).start();
    }

    private static byte[] mLock1 = new byte[0];
    private static byte[] mLock2 = new byte[0];

    private static void method1() {
        System.out.println("method1 try to get lock1");
//        Log.d(TAG,"method1 try to get lock1");
        synchronized (mLock1) {
            System.out.println("method1 get lock1 sucess");
//            Log.d(TAG,"method1 get lock1 sucess");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method1 sleep done");
//            Log.d(TAG,"method1 sleep done");
            method2();
            System.out.println("method1 call method2 done");
//            Log.d(TAG,"method1 call method2 done");
        }
    }

    private static void method2() {
        char[] b = new char[]{'a', 'b'};
        String a = b + "";
        System.out.println("method2 try to get lock2");
//        Log.d(TAG,"method2 try to get lock2");
        synchronized (mLock2) {
            System.out.println("method2 get lock2 sucess");
//            Log.d(TAG,"method2 get lock2 sucess");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method2 sleep done");
//            Log.d(TAG,"method2 sleep done");
            method1();
            System.out.println("method2 call method1 done");
//            Log.d(TAG,"method2 call method1 done");
        }
    }

}
