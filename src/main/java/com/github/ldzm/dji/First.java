package com.github.ldzm.dji;

import java.util.Scanner;

public class First {
    private static int numberOfBiteOne(int numb) {
        int count = 0;

        while(numb != 0) {
            ++count;
            numb = (numb - 1) & numb;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        int[] numbs = new int[count];
        for(int i = 0; i < count; i++) {
            numbs[i] = in.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < count; i++) {
            for(int j = i + 1; j < count; j++) {
                int numb1 = numbs[i];
                int numb2 = numbs[j];

                sum += numberOfBiteOne((numb1 ^ numb2));
            }
        }

        System.out.println(sum);
    }
}
