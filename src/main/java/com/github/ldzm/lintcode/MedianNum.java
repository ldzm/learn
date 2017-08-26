package com.github.ldzm.lintcode;

import com.github.ldzm.commom.Partition;

public class MedianNum {
	
	/**
     * @param numbs an integer array
     * @return void
     */
	public int median(int[] numbs) {

		int start = 0;
		int end = numbs.length - 1;
		
		int index = Partition.partition(numbs, 0, end);

		while (index != (numbs.length - 1) / 2) {
			if (index > (numbs.length - 1) / 2) {
				end = index - 1;
				index = Partition.partition(numbs, start, end);
			} else {
				start = index + 1;
				index = Partition.partition(numbs, start, end);
			}
		}
		
		return numbs[index];
    }

}
