package com.android.sample.module.java;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * Created by hexiaolei on 2017/7/15.
 */

public class ThreadFarmer {

    Thread.State state;
    WeakReference<String> weakReference;//通过继承WeakReference实现存储那些key为可能被回收，value为其他的值;然后遍历的时候如果key为null，则删除该元素
    Thread thread;

    public static void main(String[] args) throws Exception {
//        run();
//        new InterruptThread().stopThreadViaInterrupt();
//        new InterruptWhileSleep().run();
//        new DeprecatedMethodStop().run();
//        new ReturnViaInterrupt().run();
        new DeamonRunner().run();
    }

    /**
     * 知识点
     */
    public void objectRun() {
        weakReference.get();

        //start but not finish yet
        thread.isAlive();

        thread.setPriority(Thread.MAX_PRIORITY);

        switch (state) {
            case NEW:
            case RUNNABLE:
            case BLOCKED:
            case WAITING:
            case TIMED_WAITING:
            case TERMINATED:
        }

    }

    /**
     * 如果线程执行流程很长可以通过置interput标志位来决定是否需要继续下边的流程，当然对于判断标志位直接return的情况更优雅，
     * 但是对于有些非必须的case，可以通过判断interput标志位来选择是否执行一些可执行或不可执行的条件
     */
    static class InterruptThread {

        private void stopThreadViaInterrupt() throws Exception {
            Thread thread = new Thread(() -> {
                try {
                    print("1");
                    print("2");
                    print("3");
                    print("4");
                } catch (Exception e) {
                }
            });
            thread.start();
            TimeUnit.SECONDS.sleep(1);
            thread.interrupt();
            Thread.currentThread().yield();
        }

        private void print(String str) throws Exception {
//            if (Thread.interrupted()) {//class级别的方法，会清除interput标记
//                return;
//            }
            if (Thread.currentThread().isInterrupted()) {//Object级别方法，不会清除标记
                return;
            }
            System.out.println("step " + str);
            TimeUnit.SECONDS.sleep(1);
        }

    }

    /**
     * 无论是正在sleep还是interrupt之后sleep，都会抛出异常，所以InterruptThread的方法对于sleep要求性强的可能并不适用，会影响sleep时间
     * 但如果要求性不强，也可一试
     * 同时sleep发送异常后，也会清除interrupt标记
     */
    @Deprecated
    static class InterruptWhileSleep {
        void run() {
            try {
                Thread thread = new Thread(() -> {
                    try {
                        for (int i = 0; i < 1000; i++) {
                            System.out.println("i:" + i);
                        }
                        TimeUnit.SECONDS.sleep(3);
                    } catch (Exception e) {
                        System.out.println("exception happened while sleep,status" + Thread.currentThread().isInterrupted());
                    }
                });
                thread.start();
                TimeUnit.SECONDS.sleep(1);
                thread.interrupt();
                Thread.yield();
            } catch (Exception e) {
            }
        }

    }

    static class DeprecatedMethodStop {

        void run() {
            try {
                Thread thread = new Thread(() -> {
                    int i = 0;
                    while (true) {
                        System.out.println("i:" + i++);
                        try {
                            Thread.sleep(300);
                        } catch (Exception e) {
                            System.out.println("interrupt sleep beauty");
                        }
                    }
                });
                thread.start();
                TimeUnit.SECONDS.sleep(1);
                thread.stop();
                Thread.yield();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("DeprecatedMethodStop exception happened");
            }

        }

    }

    /**
     * interrupt与return结合使用来结束线程
     */
    static class ReturnViaInterrupt {

        void run() {
            Thread thread = new Thread(() -> {
                int i = 0;
                while (true) {
                    if (Thread.interrupted()) {
                        System.out.println("copy that,out!");
                        return;
                    }
                    System.out.println("i:" + i++);
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (Exception e) {
//                        Thread.currentThread().interrupt();//如果加sleep就会重置标记，所以需要手动重置回去？不优雅呀
//                    }
                }
            });
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
            }
            thread.interrupt();
            Thread.yield();
        }

    }

    /**
     * 守护线程，守护线程是守护应用级别的，如果应用没有其他执行线程，那守护线程也会结束自己
     * 守护线程启动的线程也是守护线程
     */
    static class DeamonRunner {

        void run() {
            NormalThread normalThread1 = new NormalThread(1000);
            NormalThread normalThread2 = new NormalThread(3000);
            NormalThread normalThread3 = new NormalThread(5000);
            NormalThread[] normalThreads = new NormalThread[]{normalThread1, normalThread2, normalThread3};
            DeamonThread deamonThread = new DeamonThread(normalThreads);

            new Thread(() -> {
                normalThread3.start();
            }).start();
            normalThread1.start();
            normalThread2.start();
            deamonThread.start();
        }

        static class NormalThread extends Thread {

            int duration;
            int i = 0;

            NormalThread(int duration) {
                this.duration = duration;
            }

            int getCountId() {
                return i;
            }

            @Override
            public void run() {
                super.run();
                while (true) {
                    if (i > duration) {
                        return;
                    }
                    System.out.println("NormalThread:" + i++);
                }
            }
        }

        static class DeamonThread extends Thread {

            NormalThread[] normalThreads;

            DeamonThread(NormalThread[] normalThreads) {
                this.normalThreads = normalThreads;
                setDaemon(true);//must called before start
            }

            @Override
            public void run() {
                super.run();
                while (true) {
                    StringBuilder sb = new StringBuilder("DeamonThread,");
                    for (int i = 0; i < normalThreads.length; i++) {
                        sb.append(",thread").append(i).append(":").append(normalThreads[i].getCountId());
                    }
                    System.out.println(sb);
                }
            }
        }
    }

}
