package com.github.ldzm.lintcode;

/**
 * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，
 * 你能有多少种不同的方法爬到楼顶部？
 */
public class ClimbStairs {

    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here

        if(n == 1 || n == 0) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }

        int oneStep = 1;
        int twoSteps = 2;
        int nextStep = oneStep + twoSteps;

        for(int i = 2; i <n; i++) {
            nextStep = oneStep + twoSteps;
            oneStep = twoSteps;
            twoSteps = nextStep;
        }

        return nextStep;
    }
}
