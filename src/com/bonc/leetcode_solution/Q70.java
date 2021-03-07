package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-07 10:57
 * @description:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Q70 {
    public static int climbStairs(int n) {
        if(n==1) return 1;
        int[] steps = new int[n];
        steps[0]=1;
        steps[1] = 2;
        for(int i=2;i<n;i++){
            steps[i] = steps[i-1]+steps[i-2];
        }
        return steps[n-1];
    }

    public static void main(String[] args) {
        int result = climbStairs(2);
        System.out.println(result);
    }
}
