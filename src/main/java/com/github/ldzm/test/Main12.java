package com.github.ldzm.test;

import java.util.Scanner;

public class Main12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Integer integer = Integer.MAX_VALUE;

        System.out.println(integer > 1000000000);
        final int num;
        num = in.nextInt();
        System.out.println(num);

        Object o = new Object();
        o.notify();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized int getNum() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
