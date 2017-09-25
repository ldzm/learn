package com.github.ldzm.algorithm;

import java.util.Arrays;

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
        int mid = -1;

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

        // 找到有边界
        left = 0;
        right = A.length - 1;
        while (left < right) {
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

    public static void main(String[] args) {
        int[] data = {5, 7, 7, 8, 8, 10};
        int target = 8;

        System.out.println(Arrays.toString(SearchRange.searchRange(data, target)));
    }
}
