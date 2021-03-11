package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-11 21:05
 * @description:
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 */
public class Q63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        memo[0][1] = 1;
        return dfs(obstacleGrid, memo, m-1, n-1);
    }

    private int dfs(int[][] obstacleGrid, int[][] memo, int i, int j){
        if(i<0||j<0||obstacleGrid[i][j]==1){
            return 0;
        }
        if(memo[i][j]!=0){
            return memo[i][j];
        }
        int res = 0;
        res += dfs(obstacleGrid, memo, i-1, j);
        res += dfs(obstacleGrid, memo, i, j-1);

        memo[i][j] = res;
        return res;
    }
}
