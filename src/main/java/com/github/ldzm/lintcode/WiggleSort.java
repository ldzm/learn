package com.github.ldzm.lintcode;

import java.util.Arrays;

public class WiggleSort {

	public static void main(String[] args) {
		int[] nums = {3, 5, 2, 1, 6, 4, 9, 7, 10};
		new WiggleSort().wiggleSort(nums);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
		int[] nums2 = {10, 9, 8, 3, 7, 1};
		new WiggleSort().wiggleSort2(nums2);
		for(int i = 0; i < nums2.length; i++) {
			System.out.print(nums2[i] + " ");
		}
	}
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here

    	Arrays.sort(nums);
    	if(nums.length <= 2) {
    		return;
    	}
    	
    	for(int i = 2; i < nums.length; i += 2) {
    		swap(nums, i, i - 1);
    	}
    }
    
    private void swap(int [] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    /**
     * 当i为奇数时，nums[i] >= nums[i - 1]
	 * 当i为偶数时，nums[i] <= nums[i - 1]
     * @param nums
     */
    public void wiggleSort2(int[] nums) {
        // Write your code here
    	if(nums.length <= 1) {
    		return;
    	}

    	for(int i = 1; i < nums.length; i++) {
    		if(((i & 1) == 1 && nums[i] < nums[i - 1]) || 
    				((i & 1) == 0 && nums[i] > nums[i - 1])) {
    			swap(nums, i, i - 1);
    		}
    	}
    }
}
