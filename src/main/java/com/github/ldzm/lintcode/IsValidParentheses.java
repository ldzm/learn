package com.github.ldzm.lintcode;

import java.util.LinkedList;

/**
 * 给定一个字符串所表示的括号序列，包含以下字符： '(', ')', '{', '}', '[' and ']'， 判定是否是有效的括号序列。
 */
public class IsValidParentheses {

    public boolean equals(char ch1, char ch2) {
        if (ch2 =='(' && ch1 == ')') {
            return true;
        }
        if (ch2 =='{' && ch1 == '}') {
            return true;
        }
        if (ch2 =='[' && ch1 == ']') {
            return true;
        }

        return false;
    }
    /*
    * @param s: A string
    * @return: whether the string is a valid parentheses
    */
    public boolean isValidParentheses(String s) {
        // write your code here

        char[] srcArray = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<Character>();

        for(char ch : srcArray) {
            if(stack.isEmpty() || !equals(ch, stack.peekFirst())) {
                stack.addFirst(ch);
            } else {
                stack.removeFirst();
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
