package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-14 20:13
 * @description:
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.
 * You must do it in place.
 *
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 */
public class Q73 {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        boolean[][] zeros = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]==0){
                    zeros[i][j] = true;
                }
            }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (zeros[i][j]){
                    colToZero(matrix, j);
                    rowToZero(matrix, i);
                }
            }
        }
    }

    private void colToZero(int[][] matrix, int col){
        for (int i=0;i<matrix.length;i++){
            matrix[i][col] = 0;
        }
    }

    private void rowToZero(int[][] matrix, int row){
        for (int j=0;j<matrix[0].length;j++){
            matrix[row][j] = 0;
        }
    }
}
