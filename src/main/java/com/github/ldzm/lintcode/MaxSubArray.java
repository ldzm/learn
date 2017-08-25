package com.github.ldzm.lintcode;

public class MaxSubArray {
	
    /*
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
    	
    	int maxSum = Integer.MIN_VALUE;
    	int sum = 0;
    	
    	//int startIndex = 0;
    	//int endIndex = 0;
    	
    	for(int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    		if(maxSum < sum) {
    			maxSum = sum;
    			//endIndex = i;
    		}
    		
    		if(sum < 0) {
    			sum = 0;
    			//startIndex = i + 1;
    		}
    	}
    	
    	//System.out.println(startIndex + " " + endIndex);
    	return maxSum;
    }
}
