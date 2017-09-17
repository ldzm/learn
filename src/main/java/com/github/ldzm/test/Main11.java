package com.github.ldzm.test;

import java.util.Scanner;

/*
2
3
1 10 100
4
1 2 3 4
 */
public class Main11 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int countOne = 0;
            int countFour = 0;
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                if (num % 4 == 0) {
                    countFour++;
                } else if (num % 2 == 1) {
                    countOne++;
                }
            }

            if (countOne <= countFour) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
