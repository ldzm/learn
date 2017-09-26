package com.github.ldzm.lintcode;

public class SearchRange {

    public static int[] searchRange(int[] A, int target) {

        int [] result = new int[2];
        if(A == null || A.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        // 找到左边界
        int left = 0;
        int right = A.length - 1;
        int mid;

        while(left < right) {
            mid = (left + right) / 2;
            if(A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if(A[left] != target) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        result[0] = left;

        // 找到右边界
        left = 0;
        right = A.length - 1;
        while (left < right) {
            // +1解决以下问题：
            // 比如数组为：2 2 2
            // target为2
            // left = (0 + 2) / 2 == 1
            // left = (1 + 2) / 2 == 1
            // left永远无法==right
            mid = (left + right + 1) / 2;
            if(A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        result[1] = right;

        return result;
    }
}
