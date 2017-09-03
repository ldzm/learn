package com.github.ldzm.test;

public class TestBytesOfChinese {
    public static void main(String[] args) {
        System.out.println("你".getBytes().length);
        System.out.println("好".getBytes().length);
        System.out.println("啊".getBytes().length);
        System.out.println("！".getBytes().length);
        System.out.println("a".getBytes().length);
        System.out.println(".".getBytes().length);
        System.out.println("1".getBytes().length);
        System.out.println("\n\r".getBytes().length);

        int num = 1;
        char ch = 'a';
        System.out.println(num + ch);

        for(int i = 0;;) {
            System.out.println("This is:" + i);
        }
    }
}
