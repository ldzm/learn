package com.github.ldzm.test;

public class VolatileTest {

    private volatile int num;
    volatile int []num2 = new int[10];

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
