package com.github.ldzm.lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请找出其中无重复字符的最长子字符串。
 */
public class LengthOfLongestSubstring {
    /**
     * @param s: a string
     * @return: an integer
     */
    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        char[] charArray = s.toCharArray();
        int[] lengthOfSubString = new int[s.length()];
        Map<Character, Integer> indexOfChar = new HashMap<Character, Integer>();

        indexOfChar.put(charArray[0], 0);
        lengthOfSubString[0] = 1;

        // 求出以没有给字符结尾的最长无重复字符串的长度
        for (int i = 1; i < charArray.length; i++) {
            Integer preCharIndex = indexOfChar.get(charArray[i]);

            if(preCharIndex == null) {

                lengthOfSubString[i] = lengthOfSubString[i - 1] + 1;
            } else {
                if (preCharIndex + 1 >= i - lengthOfSubString[i - 1]) {

                    lengthOfSubString[i] = i - preCharIndex;
                } else {

                    lengthOfSubString[i] = lengthOfSubString[i - 1] + 1;
                }
            }
            indexOfChar.put(charArray[i], i);
        }

        int result = Integer.MIN_VALUE;
        // 找到最大的长度
        for(int i = 0; i < lengthOfSubString.length; i++) {
            if(lengthOfSubString[i] > result) {
                result = lengthOfSubString[i];
            }
        }

        return result;
    }
}
