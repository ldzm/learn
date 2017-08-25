package com.github.ldzm.lintcode;

public class KthLargestElement {
	
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     * 第K大的数，partition用降序排序，前面都是大于第K个数的，那么第K个数就是第K大个数
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
	
		int start = 0;
		int end = nums.length - 1;
		
		int index = partion(nums, 0, end);

		while (index != k - 1) {
			if (index > k -1) {
				end = index - 1;
				index = partion(nums, start, end);
			} else {
				start = index + 1;
				index = partion(nums, start, end);
			}
		}
		
		return nums[index];
    }
    
    private int partion(int[] nums, int start, int end) {

    	int index = randomRange(start, end);
    	swap(nums, index, end);
    	int small = start - 1;
    	
    	for(index = start; index < end; index++) {
    		if (nums[index] >= nums[end]) {
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
    
    private void swap(int [] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}
