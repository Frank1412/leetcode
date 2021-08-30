package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-13 15:53
 * @description:
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 */
public class Q64 {
    public int minPathSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] path = new int[m][n];
        path[0][0] = grid[0][0];
        for (int i=1;i<m;i++){
            path[i][0] = path[i-1][0] + grid[i][0];
        }
        for (int j=1;j<n;j++){
            path[0][j] = path[0][j-1] + grid[0][j];
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                path[i][j] = Math.min(path[i-1][j], path[i][j-1])+grid[i][j];
            }
        }
        return path[m][n];
    }
}
