package com.github.ldzm.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumer {


    public static void main(String[] args) {

        // 参数设置容量（必须），第二个参数设置是否为公平锁，默认是非公平锁
        ArrayBlockingQueue<Planet> queue = new ArrayBlockingQueue<>(3);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Producer implements Runnable {

    private BlockingQueue<Planet> queue;
    private volatile int count = 0; // 并不能保证线程安全

    Producer(BlockingQueue<Planet> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while(true) {
            Planet planet = new Planet(count++);
            try {
                queue.put(planet);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("勤劳的人们生产了星星" + planet.getPlanetId() + " 号行星，并放入了宇宙！" +
            "总共剩余：" + queue.size() + "颗行星！");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    private BlockingQueue<Planet> queue;

    Consumer(BlockingQueue<Planet> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            Planet planet = null;
            try {
                planet = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            assert planet != null;
            System.out.println("黑暗势力消灭了" + planet.getPlanetId() + "号行星><" + "总共剩余：" + queue.size() + "颗行星！");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Planet {
    private int planetId;


    Planet(int planetId) {
        this.planetId = planetId;
    }

    int getPlanetId() {
        return planetId;
    }
}