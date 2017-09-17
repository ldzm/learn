package com.github.ldzm.test;

import java.util.Scanner;


/**
 * Created by 糖糖 on 2017/9/8.
 */
public class Pi {
    public static void main(String args[]) {

        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        double[] input = new double[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.nextDouble();
        }
        double max = 0;
        int p = 0, q = 1;
        while (q < n) {
            while (q < n && input[q] - input[p] <= 180) {
                max = max > input[q] - input[p] ? max : input[q] - input[p];
                q++;
            }
            while (q < n && p < q && input[q] - input[p] > 180) {
                max = max > (360 - (input[q] - input[p])) ? max : (360 - (input[q] - input[p]));
                p++;
            }
        }

        System.out.format("%.8f", max);
        System.out.flush();
    }
}