package com.github.ldzm.test;

public class LockObjectTest {
    public static void main(String[] args) throws InterruptedException {
        Object o = null;
        //synchronized (o) {
        synchronized (args) {
            System.out.println("Hello.");
        }

        LockTest lockTest = new LockTest();
        LockTest lockTest2 = new LockTest();
        new Thread() {
            @Override
            public void run() {
                lockTest.displayHello();
            }
        }.start();

        // 睡眠1s，为了让上一个线程先获取lockTest的锁
        Thread.sleep(1000);

        new Thread() {
            @Override
            public void run() {
                // 和上一个线程是同同一个对象，存在锁竞争，要等待第一个线程释放锁后才能获取锁，输出Hi
                //lockTest.displayHi();
                // 和上一个线程不是同同一个对象，不存在所竞争，直接输出Hi
                lockTest2.displayHi();
            }
        }.start();
    }
}

class LockTest {

    public synchronized void displayHello() {
        System.out.println("Hello!");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void displayHi() {
        System.out.println("Hi!");
    }
}