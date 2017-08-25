package com.github.ldzm.lintcode;


import java.util.LinkedList;

public class ReverseWords {

    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * 反转字符串，单词字符的次序不变
     * 使用栈
     * @param s: A string
     * @return: A string
     */
    public String reverseWords2(String s) {
        // write your code here

        StringBuilder result = new StringBuilder();
        LinkedList<String> stack = new LinkedList<String>();

        String[] words = s.split(" ");

        for(String word : words) {
            stack.addFirst(word);
        }

        while(!stack.isEmpty()) {
            result.append(stack.removeFirst());
            result.append(" ");
        }

        return result.toString();
    }

    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * 对每个字符中的单词进行翻转
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here

        StringBuilder result = new StringBuilder();

        String[] words = s.split(" ");

        for(String word : words) {
            result.append(reverse(word));
            result.append(" ");
        }

        return result.toString();
    }

    private char[] reverse(String words) {
        char[] wordsArray = words.toCharArray();
        int length = wordsArray.length;

        int index = 0;
        while(index < length / 2) {
            char temp = wordsArray[index];
            wordsArray[index] = wordsArray[length - index - 1];
            wordsArray[length - index - 1] = temp;

            index++;
        }

        return wordsArray;
    }
}
