package com.github.ldzm.didi;

import com.github.ldzm.commom.Partition;

import java.util.Scanner;

public class Second {

    private static int kthLargestElement(int k, int[] numbs) {

        int start = 0;
        int end = numbs.length - 1;

        int index = Partition.partition(numbs, 0, end);

        while (index != numbs.length - k) {
            if (index > numbs.length - k) {
                end = index - 1;
                index = Partition.partition(numbs, start, end);
            } else {
                start = index + 1;
                index = Partition.partition(numbs, start, end);
            }
        }

        return numbs[index];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String [] numbs = in.nextLine().split(" ");
        int k = in.nextInt();

        int length = numbs.length;
        int[] numbsArray = new int[length];

        for(int i = 0; i < numbs.length; i++) {
            numbsArray[i] = Integer.parseInt(numbs[i]);
        }

        System.out.println(kthLargestElement(k ,numbsArray));
    }
}