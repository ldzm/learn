package com.github.ldzm.lintcode;

public class SingleNumber {

    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int singleNumber(int[] A) {

        if(A.length == 0) {
            return  0;
        }

        int result = A[0];

        for (int i = 1; i < A.length; i++) {
            result ^= A[i];
        }

        return result;
    }
}
