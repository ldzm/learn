package com.github.ldzm.lintcode;

/**
 * 合并两个排序的整数数组A和B变成一个新的数组。
 */
public class MergeSortedArray {

    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here

        // 把数组A的元素都移动到数组的后面，防止在合并的过程中频繁移动
        int [] result = new int[A.length + B.length];

        int indexB = 0;
        int indexA = 0;
        int i = 0;
        while(A.length != indexA && B.length != indexB) {
            if(A[indexA] < B[indexB]) {
                result[i] = A[indexA++];
            } else {
                result[i] = B[indexB++];
            }
            i++;
        }

        if (A.length == indexA) {
            while (indexB < B.length) {
                result[i++] = B[indexB++];
            }
        }

        if (B.length == indexB) {
            while (indexA < A.length) {
                result[i++] = A[indexA++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] A = {1};
        int [] B = {1};

        int[] result = new MergeSortedArray().mergeSortedArray(A, B);

        for(int num : result) {
            System.out.println(num);
        }
    }
}
