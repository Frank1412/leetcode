package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-08 20:21
 * @description: Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class Q279 {
    /**
     * 状态转移方程： dp[i] = MIN(dp[i], dp[i - j * j] + 1)
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            res[i] = i;
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }
        return res[n];
    }


    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
