package com.github.ldzm.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairLockTest {

    private static ReentrantLock2 fairLock = new ReentrantLock2(true);
    private static ReentrantLock2 unfairLock = new ReentrantLock2(false);

    public void fair() {
        testLock(fairLock);
    }

    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(ReentrantLock2 lock) {
        // 启动5个Job
        for(int i = 0; i < 5; i++) {
            new Job(lock).start();;
        }
    }

    private static class Job extends Thread {
        private ReentrantLock2 lock;

        public Job(ReentrantLock2 lock) {
            this.lock = lock;
        }

        public void run() {// 连续2次打印当前的Thread和等待队列中的Thread（略）
            lock.lock();
            System.out.print(Thread.currentThread().getId() + "   [");
            for(Thread t : lock.getQueuedThreads()) {
                System.out.print(t.getId() + " ");
            }
            System.out.println("]");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            lock.lock();
            System.out.print(Thread.currentThread().getId() + "   [");
            for(Thread t : lock.getQueuedThreads()) {
                System.out.print(t.getId() + " ");
            }
            System.out.println("]");
            lock.unlock();
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    public static void main(String[] args) {
        //new FairAndUnfairLockTest().fair();
        new FairAndUnfairLockTest().unfair();
    }
}