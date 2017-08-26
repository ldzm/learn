package com.github.ldzm.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class First {

    private static int maxSubArray(List<Integer> numbs) {

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (Integer num : numbs) {
            sum += num;
            if (maxSum < sum) {
                maxSum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }

        System.out.println(maxSubArray(list));
    }
}