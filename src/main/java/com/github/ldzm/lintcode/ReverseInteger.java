package com.github.ldzm.lintcode;


/**
 * 将一个整数中的数字进行颠倒，当颠倒后的整数溢出时，返回 0 (标记为 32 位整数)。
 */
public class ReverseInteger {

    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {

        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
        }

        int result = 0;
        int cur = Math.abs(n);
        while (cur != 0) {

            // 处理整数移除
            if((Integer.MAX_VALUE - cur % 10) / 10 < result) {
                return 0;
            }

            result = result * 10 + cur % 10;
            cur = cur / 10;
        }

        if (isNegative) {
            result = -result;
        }

        return result;
    }
}
