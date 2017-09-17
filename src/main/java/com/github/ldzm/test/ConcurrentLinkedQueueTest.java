package com.github.ldzm.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {

        // 无界，不允许null
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        //concurrentLinkedQueue.add(null);

        // 有界，不允许null，不设置大小默认是Int的最大值
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        linkedBlockingQueue.add(null);


        // 有界，不允许null，必须设置大小
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10);
        //arrayBlockingQueue.add(null);

        // 有界，不允许null，不设置大小默认是Int的最大值
        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();
        //linkedBlockingDeque.add(null);
    }
}
