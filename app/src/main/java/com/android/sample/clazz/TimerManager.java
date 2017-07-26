package com.android.sample.clazz;

/**
 * Created by hexiaolei on 2017/5/8.
 */

public class TimerManager {

    static {
        System.out.println("123");
    }

//    private Timer mTimer = null;
//    private TimerTask mTimeTask = null;
    private static final long SCHEDULE_TIME = 2000;

    public TimerManager(String a){
//        mTimer = new Timer();
//        mTimeTask = new TimerTask() {
//            @Override
//            public void run() {
//                Log.d("hxl","定时任务");
//            }
//        };
    }

//    public static TimerManager getInstance(){
//        return InnerClass.mInstance;
//    }

    private static class InnerClass {
//        static TimerManager mInstance = new TimerManager();
    }

    /**
     * 仅被调用一次，如何知道运行状态
     */
//    public void startTimer(){
//        mTimer.schedule(mTimeTask,0,SCHEDULE_TIME);
//    }

}
