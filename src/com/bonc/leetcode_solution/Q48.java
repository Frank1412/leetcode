package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-06 10:43
 * @description:
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 */

public class Q48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0;i<n/2;i++){
            for (int j=0;j<(n+1)/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;

            }
        }
    }

    private void swap(int i, int j, int[][] matrix){
        int time = 4;
        int tmp = matrix[i][j];
        while (time>0){
            int m=j, n=matrix.length-1-i;
            int cur = matrix[m][n];
            matrix[j][matrix.length-1-i] = tmp;
            i=m;
            j=n;
            tmp = cur;
            time--;
        }

    }
}
