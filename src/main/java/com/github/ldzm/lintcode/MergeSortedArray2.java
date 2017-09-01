package com.github.ldzm.lintcode;

/**
 * 合并两个排序的整数数组A和B变成一个新的数组。
 */
public class MergeSortedArray2 {

    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here

        // 把数组A的元素都移动到数组的后面，防止在合并的过程中频繁移动
        for(int i = m - 1, j = A.length - 1; i >= 0; i--, j--) {
            A[j] = A[i];
        }

        int indexB = 0;
        int indexA = A.length - m;
        int i = 0;
        while(A.length != indexA && n != indexB) {
            if(A[indexA] < B[indexB]) {
                A[i] = A[indexA++];
            } else {
                A[i] = B[indexB++];
            }
            i++;
        }

        if (A.length == indexA) {
            while (indexB < n) {
                A[i++] = B[indexB++];
            }
        }

        if (n == indexB) {
            while (indexA < A.length) {
                A[i++] = A[indexA++];
            }
        }
    }

    public static void main(String[] args) {
        int [] A = {1,3,4,6, 0, 0, 0, 0};
        int m = 4;
        int [] B = {2,5};
        int n = 2;
        new MergeSortedArray2().mergeSortedArray(A, m, B, n);

        for(int num : A) {
            System.out.println(num);
        }
    }
}
