package com.github.ldzm.lintcode;

/**
 * 判断一个正整数是不是回文数。
 * 回文数的定义是，将这个数反转之后，得到的数仍然是同一个数
 */
public class IsPalindrome {

    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // write your code here

        char[] nums = new Integer(num).toString().toCharArray();

        int length = nums.length;
        int count = 0;

        while(count < length) {
            if(nums[length - count - 1] == nums[count]) {
                count++;
                continue;
            }

            return false;
        }

        return true;
    }
}
