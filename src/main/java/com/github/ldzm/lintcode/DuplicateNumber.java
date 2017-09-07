package com.github.ldzm.lintcode;

/*
找数组中唯一出现2次的数.cpp : Defines the entry point for the console application.
假设你有一个用1001个整数组成的数组，这些整数是任意排列的，但是你知道所有的整数都在1到1000(包括1000)之间。
此外，除一个数字出现两次外，其他所有数字只出现一次。假设你只能对这个数组做一次处理，用一种算法找出重复的那个数字。
如果你在运算中使用了辅助的存储方式，那么你能找到不用这种方式的算法吗?

1001个数异或结果与1-1000异或的结果再做异或，得出的值即位所求。
原理：
设重复数为A，其余999个数异或结果为B。
1001个数异或结果为A^A^B
1-1000异或结果为A^B
由于异或满足交换律和结合律，且X^X = 0  0^X = X;
则有
(A^B)^(A^A^B)=A^B^B=A
*/
public class DuplicateNumber {

    public static int duplicateNumber(int[] numbs) {

        if (numbs == null) {
            throw new RuntimeException("Invalid parameter!");
        }

        int result = 0;
        for (int numb : numbs) {
            result ^= numb;
        }

        for (int i = 1; i < numbs.length; i++) {
            result ^= i;
        }

        return result;
    }

    public static int duplicateNumberFormula(int[] numbs) {

        if (numbs == null) {
            throw new RuntimeException("Invalid parameter!");
        }

        int sum = 0;
        int count = numbs.length;

        for (int numb : numbs) {
            sum += numb;
        }

        return sum - (count - 1) * count / 2;
    }

    public static void main(String[] args) {
        int[] numbs = {1, 2, 3, 4, 4};
        System.out.println(DuplicateNumber.duplicateNumber(numbs));
        System.out.println(DuplicateNumber.duplicateNumberFormula(numbs));
    }
}
