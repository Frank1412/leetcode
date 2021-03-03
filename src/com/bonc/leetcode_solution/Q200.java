package com.bonc.leetcode_solution;

/**
 * @Author: Frank
 * @Date: 2021-03-03 10:32
 * @Description: Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class Q200 {
    int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int count = 0;
    public int numIslands(char[][] grid) {
        int m=grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int m, int n){
        if (grid[i][j]=='1'){
            grid[i][j] = '2';
            for(int[] dir: direction){
                int x=i+dir[0], y=j+dir[1];
                if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]!='2'){
                    dfs(grid, x, y, m, n);
                }
            }
        }
    }
}
