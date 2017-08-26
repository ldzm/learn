package com.github.ldzm.commom;

public class Partition {
    public static  int partition(int[] numbs, int start, int end) {

        int index = randomRange(start, end);
        swap(numbs, index, end);
        int small = start - 1;

        for(index = start; index < end; index++) {
            if (numbs[index] <= numbs[end]) {
                small++;
                if (small != index) {
                    swap(numbs, small, index);
                }
            }
        }

        small++;
        swap(numbs, small, end);

        return small;
    }

    private static  int randomRange(int start, int end) {

        return start + (int) ((end - start + 1) * Math.random());
    }

    private static  void swap(int [] numbs, int i, int j) {
        int temp = numbs[i];
        numbs[i] = numbs[j];
        numbs[j] = temp;
    }
}
