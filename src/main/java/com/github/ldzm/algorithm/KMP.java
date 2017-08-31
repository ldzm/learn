package com.github.ldzm.algorithm;

public class KMP {

    public static int kmp(String source, String target) {

        if(source == null || target == null) {
            return -1;
        }

        if(target.length() == 0) {
            return 0;
        }
        char[] src = source.toCharArray();
        char[] targt = target.toCharArray();
        int[] next = new int[targt.length];
        next[0] = -1;
        // 求next函数
        for(int i = 1; i < targt.length; i++) {
            int j = next[i - 1];

            while ((targt[j + 1] != targt[i]) && (j >= 0)) {
                j = next[j];
            }

            if(targt[j + 1] == targt[i]) {
                next[i] = j + 1;
            } else {
                next[i] = -1;
            }
        }

        int i = 0;
        int j = 0;
        while(i < src.length) {
            if(src[i] == targt[j]) {
                i++;
                j++;
                if (j == targt.length) {
                    //j = next[j - 1] + 1;
                    return i - targt.length;
                }
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = next[j - 1] + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String src = "abaabaabbabaaabaabbabaab";
        String match = "abaabbabaab";

        kmp(src, match);
    }
}
