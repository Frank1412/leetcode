package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-14 10:27
 * @description:
 */
public class Q304 {

    int[][] mt, memo;
    public void NumMatrix(int[][] matrix) {
        mt = matrix;
        memo = new int[mt.length][mt[0].length];
        dfs(mt.length-1, mt[0].length-1);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dfs(row2, col2)-dfs(row2, col1-1)-dfs(row1-1, col2)+dfs(row1-1, col1-1);
//        return memo[row2][col2]-memo[row2][col1-1]-memo[row1-1][col2]+memo[row1-1][col1-1];
    }

    private int dfs(int row, int col){
        if(row<0||col<0){
            return 0;
        }
        if (memo[row][col]!=0){
            return memo[row][col];
        }

        int up = dfs(row-1, col);
        int left = dfs(row, col-1);
        int intersect = dfs(row-1, col-1);
        int res = up + left - intersect + mt[row][col];
        memo[row][col] = res;
        return res;
    }

    public static void main(String[] args) {
        int[][] a = new int[0][0];
        boolean[] b = new boolean[2];
        System.out.println(b[0]);
    }
}
