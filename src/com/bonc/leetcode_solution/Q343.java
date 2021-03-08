package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-08 19:51
 * @description: Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 */
public class Q343 {
    public int integerBreak(int n) {
        if (n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int[] res = new int[n+1];
        return dfs(n, res);
    }

    public int dfs(int n, int[] res) {
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }

        if (res[n] != 0) {
            return res[n];
        }
        int max = 1;
        for (int i = 2; i <= n - i; i++) {
            max = Math.max(dfs(n - i, res) * i, max);
        }
        res[n] = max;
        return max;
    }
}
