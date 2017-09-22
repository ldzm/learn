package com.github.ldzm.algorithm;

import java.util.*;

public class BaseConversion {

    /**
     * 简单的10进制转其他进制的程序，仅仅描述用栈实现进制转换的思想
     *
     * 思路：以10进制转8进制为例
     * numb = 100 = 4 * 8 ^0 + 4 * 8 ^1 + 1 * 8 ^2
     * 100 % 8 == 4，因为后面的数是可以被8整除的
     * numb = 100 / 8
     * numb = 4 * 8 ^ 0 + 1 * 8 ^ 1
     * numb % 8 == 4
     * numb = numb / 8 = 1 * 8
     * numb % 8 = 1
     *
     * 依次获取4 4 1
     */
    public static List<Integer> conversion(int numb, int base) {

        ArrayList<Integer> result = new ArrayList<>();

        if(base == 0) {
            throw new RuntimeException("Invalid parameter!");
        }

        if(numb == 0) {
            result.add(0);
            return result;
        }

        Stack<Integer> stack = new Stack<>();

        while(numb != 0) {
            stack.push(numb % base);
            numb = numb / base;
        }

        while(!stack.empty()) {
            result.add(stack.pop());
        }

        Collections.reverse(result);

        return result;
    }
}
