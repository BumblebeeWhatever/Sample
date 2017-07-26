package com.android.sample.module.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hexiaolei on 2017/7/25.
 */

public class QueueRunner {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
    }

}
