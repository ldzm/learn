package com.github.ldzm.lintcode;

import java.util.*;

public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here

        Arrays.sort(numbers);
        HashMap<Integer, Integer> numbs = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            numbs.put(numbers[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> sets = new HashSet<>();
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                int a = -numbers[j] - numbers[i];
                if(numbs.containsKey(a) && numbs.get(a) > j) {
                    ArrayList<Integer> temp = new ArrayList<>(3);
                    temp.add(numbers[i]);
                    temp.add(numbers[j]);
                    temp.add(a);
                    sets.add(temp);
                }
            }
        }

        for(List<Integer> list : sets) {
            result.add(list);
        }
        return result;
    }
}
