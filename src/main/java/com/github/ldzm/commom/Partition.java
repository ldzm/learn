package com.github.ldzm.commom;

public class Partition {
    public static  int partion(int[] nums, int start, int end) {

        int index = randomRange(start, end);
        swap(nums, index, end);
        int small = start - 1;

        for(index = start; index < end; index++) {
            if (nums[index] <= nums[end]) {
                small++;
                if (small != index) {
                    swap(nums, small, index);
                }
            }
        }

        small++;
        swap(nums, small, end);

        return small;
    }

    private static  int randomRange(int start, int end) {

        int result = start + (int) ((end - start + 1) * Math.random());
        return result;
    }

    private static  void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
