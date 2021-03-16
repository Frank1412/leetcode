package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-16 20:31
 * @description: Given a string s, find the longest palindromic subsequence's length in s.
 * <p>
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 */
public class Q516 {

    int[][] memo;

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        memo = new int[n][n];
        return dfs(s, 0, n - 1);
    }

    private int dfs(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i==j){
            return 1;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int res;
        if (s.charAt(i) == s.charAt(j)) {
            res = dfs(s, i + 1, j - 1) + 2;
        } else {
            res = Math.max(dfs(s, i, j - 1), dfs(s, i + 1, j));
        }
        return memo[i][j] = res;
    }
}
