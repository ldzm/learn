package com.github.ldzm.lintcode;

import com.github.ldzm.commom.Partition;

public class QuickSort {
	
	/**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
    	quickSort(A, 0, A.length - 1);
    }

    public void quickSort(int[] nums, int start, int end) {
        // Write your code here
    	if(start >= end) {
    		return;
    	}
		int index = Partition.partion(nums, start, end);

		if (index > start) {
			quickSort(nums, start, index - 1);
		}
		if (index < end) {
			quickSort(nums, index + 1, end);
		}
    }
}
