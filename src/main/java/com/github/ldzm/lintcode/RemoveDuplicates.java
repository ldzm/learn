package com.github.ldzm.lintcode;

/**
 * 给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。
 */
public class RemoveDuplicates {
    /**
     * @param numbs: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] numbs) {
        // write your code here
        if(numbs == null) {
            return 0;
        }

        boolean flag = true; // 判断是否找到下一个非重复的数
        int j = 0; // 整理后的数组的索引
        for(int i = 0; i < numbs.length; i++) {

            // 找到第k个可用的数，即numbs中第i个非重复的数，如果重复，则i++
            while (!flag) {
                if(numbs[j - 1] == numbs[i]){
                    i++;
                    if(i == numbs.length ) {
                        break;
                    }
                } else {
                    flag = true;
                }
            }

            // 判断是不是找到了这个数
            if(flag) {
                numbs[j++] = numbs[i];
                flag = false;
            }
        }

        return j;
    }
}
