package com.github.ldzm.test;

public class EqualsTest {

    public static void main(String[] args) {
        Integer integer = new Integer(8);
        Integer integer2 = 8;
        int i = 8;

        System.out.println(integer == integer2);
        System.out.println(i == integer2);

        Integer integer3 = 1000;
        i = 1000;
        System.out.println(integer3 == i);


        integer = Integer.valueOf(127);
        integer2 = Integer.valueOf(127);
        System.out.println(integer == integer2);

        integer = Integer.valueOf(128);
        integer2 = Integer.valueOf(128);
        System.out.println(integer == integer2);

        i = 0;
        while(i < (i++) + 1) {

        }

        System.out.println(i);

        Integer integer4;
        int k = 1;
        integer4 = 1;
        new SubThread2(integer).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(integer4);
        new SubThread2(integer).start();
    }
}

class SubThread2 extends Thread {
    private volatile Integer integer;

    public SubThread2(Integer integer) {
        this.integer = integer;
    }

    @Override
    public void run() {
        if(integer != 10) {
            integer = 10;
            System.out.println(integer);
        } else {
            System.out.println(integer);
        }
    }
}