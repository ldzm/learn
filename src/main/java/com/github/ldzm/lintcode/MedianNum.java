package com.github.ldzm.lintcode;

import com.github.ldzm.commom.Partition;

public class MedianNum {
	
	/**
     * @param nums an integer array
     * @return void
     */
	public int median(int[] nums) {

		int start = 0;
		int end = nums.length - 1;
		
		int index = Partition.partion(nums, 0, end);

		while (index != (nums.length - 1) / 2) {
			if (index > (nums.length - 1) / 2) {
				end = index - 1;
				index = Partition.partion(nums, start, end);
			} else {
				start = index + 1;
				index = Partition.partion(nums, start, end);
			}
		}
		
		return nums[index];
    }

}
