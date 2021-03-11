package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-11 21:30
 * @description:
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class Q1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(), n=text2.length();
        int[][] memo = new int[m][n];

        return dfs(memo, text1, text2, m-1, n-1);
    }

    private int dfs(int[][] memo, String text1, String text2, int i, int j){
        if(i<0||j<0){
            return 0;
        }
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        int res = 0;
        if(text1.charAt(i)==text2.charAt(j)){
            res = dfs(memo, text1, text2, i-1, j-1)+1;
        }else{
            res = Math.max(dfs(memo, text1, text2, i-1, j), dfs(memo, text1, text2, i, j-1));
        }

        memo[i][j] = res;
        return res;
    }
}
