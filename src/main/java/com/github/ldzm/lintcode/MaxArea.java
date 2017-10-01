package com.github.ldzm.lintcode;

public class MaxArea {
    /**
     * @param heights: a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if(heights == null || heights.length < 2) {
            return 0;
        }

        int maxArea = 0;

        int leftIndex = 0;
        int rightIndex = heights.length - 1;
        while(leftIndex < rightIndex) {
            int currentArea = 0;
            if(heights[leftIndex] < heights[rightIndex]) {
                currentArea = (rightIndex - leftIndex) * heights[leftIndex];
                leftIndex++;
            } else {
                currentArea = (rightIndex - leftIndex) * heights[rightIndex];
                rightIndex--;
            }

            if(currentArea > maxArea) {
                maxArea = currentArea;
            }
        }

        return maxArea;
    }
}
