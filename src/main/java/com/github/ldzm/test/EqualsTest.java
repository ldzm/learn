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

    }
}
