package com.github.ldzm.test;

public class ThreadRunableRunTest {

    public static void main(String[] args) {
        new Thread(new RunnableImp()).start();

        new SubThread().start();
        
        new SubThread(new RunnableImp()).start();
    }
}

class SubThread extends Thread {

    public SubThread() {
    }

    public SubThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        System.out.println("SubThread!");
    }
}

class RunnableImp implements Runnable {
    @Override
    public void run() {
        System.out.println("RunnableImp");
    }
}