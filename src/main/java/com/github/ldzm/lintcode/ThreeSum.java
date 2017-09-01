package com.github.ldzm.lintcode;

import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here

        Arrays.sort(numbers);

        for(int num3Index = 0; num3Index < numbers.length - 2; num3Index++) {

            int target = numbers[num3Index];

        }
        return null;
    }
}
