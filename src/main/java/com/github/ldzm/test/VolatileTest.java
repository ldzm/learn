package com.github.ldzm.test;

public class VolatileTest {

    private volatile int num;
    volatile int []num2 = new int[10];
    public static final int NUMBS = 100000;
    public static void main(String[] args) {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        int index = (int)(Math.random() * NUMBS);
        for(int i = 0; i < NUMBS; i++) {
            System.out.print(index + " ");
        }

    }
}
