package com.github.ldzm.test;

import java.util.Scanner;

public class FinalTest {
    final int num;

    public FinalTest(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static void main(String[] args) {

        final FinalTest finalTest = null;

        Scanner in = new Scanner(System.in);
        int flag = in.nextInt();
        if(flag == 1) {
            //finalTest = new FinalTest(1);
        }
        System.out.println(finalTest.getNum());
    }


}
