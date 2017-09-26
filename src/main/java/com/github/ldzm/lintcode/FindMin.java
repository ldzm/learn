package com.github.ldzm.lintcode;


/**
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 你可以假设数组中不存在重复的元素。
 */
public class FindMin {

    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here

        int left = 0;
        int right = nums.length - 1;
        int mid;

        if(nums[left] < nums[right]) {
            return nums[left];
        }
        while(left < right) {

            //mid = (left + right) / 2;
            mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
