package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-13 22:24
 * @description:
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */
public class Q62 {

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        memo[0][0]=1;

        return dfs(m-1, n-1, memo);
    }

    public int dfs(int i, int j, int[][] memo){
        if (i<0||i>memo.length-1||j<0||j>memo[0].length-1){
            return 0;
        }
        if(memo[i][j]!=0){
            return memo[i][j];
        }

        int left = dfs(i, j-1, memo);
        int up = dfs(i-1, j, memo);
        int res = left+up;
        memo[i][j] = res;
        return res;
    }
}
