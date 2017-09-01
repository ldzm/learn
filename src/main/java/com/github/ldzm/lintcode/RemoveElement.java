package com.github.ldzm.lintcode;

/**
 * 给定一个数组和一个值，在原地删除与值相同的数字，返回新数组的长度。
 * 元素的顺序可以改变，并且对新的数组不会有影响。
 */
public class RemoveElement {

    /**
     *@param numbs: A list of integers
     *@param element: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] numbs, int element) {
        // write your code here

        if(numbs == null) {
            return 0;
        }

        boolean flag = false; // 判断是否找到不等于element的数
        int j = 0; // 整理后的数组的索引
        for(int i = 0; i < numbs.length; i++) {
            while (!flag) {
                if(element == numbs[i]) {
                    i++;
                    if(i == numbs.length) {
                        break;
                    }
                } else {
                    flag = true;
                }
            }

            if(flag) {
                numbs[j++] = numbs[i];
                flag = false;
            }
        }

        return j;
    }
}
