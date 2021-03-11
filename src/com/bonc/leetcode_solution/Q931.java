package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-11 21:47
 * @description:
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class Q931 {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] memo = new int[m][n];

        int res = dfs(memo, matrix, 0,0);
        System.out.println(res);
        for(int i=1;i<n;i++){
            res = Math.min(res, dfs(memo, matrix, 0, i));
        }
        return res;
    }

    private int dfs(int[][] memo, int[][] matrix, int i, int j){
        if(i>=matrix.length||j<0||j>=matrix[0].length){
            return 0;
        }

        if(memo[i][j]!=0){
            return memo[i][j];
        }

        int left = dfs(memo, matrix, i+1, j-1);
        int mid = dfs(memo, matrix, i+1, j);
        int right = dfs(memo, matrix, i+1, j+1);
        int res;
        if (j==0){
            res = Math.min(mid, right)+matrix[i][j];
        }else if(j==matrix[0].length-1){
            res = Math.min(mid, left)+matrix[i][j];
        } else{
            res = Math.min(Math.min(left, right), mid)+matrix[i][j];
        }
        memo[i][j] = res;
        return res;
    }

}
