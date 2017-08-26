package com.github.ldzm.lintcode;

import com.github.ldzm.commom.Partition;

public class QuickSort {
	
	/**
     * @param A an integer array
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
    	quickSort(A, 0, A.length - 1);
    }

    public void quickSort(int[] numbs, int start, int end) {
        // Write your code here
    	if(start >= end) {
    		return;
    	}
		int index = Partition.partition(numbs, start, end);

		if (index > start) {
			quickSort(numbs, start, index - 1);
		}
		if (index < end) {
			quickSort(numbs, index + 1, end);
		}
    }
}
