package com.github.ldzm.lintcode;

import java.util.Stack;

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

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            if(stack.isEmpty() || heights[stack.peek()] < heights[i]){
                stack.push(i);
            } else {
                int leftIndex = stack.pop();
                int right = i;
                if((right - leftIndex) * heights[leftIndex] > max) {
                    max = (right - leftIndex) * heights[leftIndex];
                }
            }
        }

        return max;
    }
}
