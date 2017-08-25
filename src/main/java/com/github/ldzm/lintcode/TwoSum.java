package com.github.ldzm.lintcode;

import java.util.HashMap;

/**
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
 *
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 1 到 n，不是以 0 开头。
 *
 * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [1, 2].
 */
public class TwoSum {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int [] result = new int[2];

        for(int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for(int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if(map.containsKey(temp) && map.get(temp) != i) {
                result[0] = i + 1;
                result[1] = map.get(temp) + 1;
                break;
            }
        }

        return result;
    }
}
