package com.github.ldzm.lintcode;

import java.util.List;

public class MajorityNumber {
	
	/**
     * @param A an integer array
     * @return void
     * 正常情况下需要判断求出来的中间的那个数的个数是不是超过一半
     * 求的算法是O(n)
     * 由于是链表，判断一个数的个数是不是超过一半的时间复杂度是O(n*n)
     */
	public int majorityNumber(List<Integer> nums) {
        // Write your code here
	
		int start = 0;
		int end = nums.size() - 1;
		
		int index = partion(nums, 0, end);
		int length = nums.size();

		while (index != (length - 1) / 2) {
			if (index > (length - 1) / 2) {
				end = index - 1;
				index = partion(nums, start, end);
			} else {
				start = index + 1;
				index = partion(nums, start, end);
			}
		}
		
		for(int num : nums) {
			
		}
		return nums.get(index);
    }
    
    private int partion(List<Integer> nums, int start, int end) {

    	int index = randomRange(start, end);
    	swap(nums, index, end);
    	int small = start - 1;
    	
    	for(index = start; index < end; index++) {
    		if (nums.get(index) <= nums.get(end)) {
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
    
    private int randomRange(int start, int end) {
    	
    	int result = start + (int) ((end - start + 1) * Math.random());
    	return result;
    }
    
    private void swap(List<Integer> nums, int i, int j) {
    	int temp = nums.get(i);
    	nums.set(i, nums.get(j));
    	nums.set(j, temp);
    }
}
