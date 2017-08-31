package com.github.ldzm.lintcode;

/**
 * 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。
 * 给定 [1,2,3] 表示 123, 返回 [1,2,4].
 * 给定 [9,9,9] 表示 999, 返回 [1,0,0,0].
 */
public class PlusOne {

    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here

        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] + carry == 10) {
                carry = 1;
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
                break;
            }
        }

        if(carry == 0){
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        }
    }
}
