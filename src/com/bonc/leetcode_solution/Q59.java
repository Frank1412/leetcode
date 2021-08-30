package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-12 23:23
 * @description:
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 *
 */
public class Q59 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top=0, down=n-1, left=0,right=n-1, circle=n/2, num=1, i=top, j=left;
        while (circle>0){
            while (j < right) {
                matrix[i][j] = num;
                num++;
                j++;
            }
            while (i < down) {
                matrix[i][j] = num;
                num++;
                i++;
            }
            while (j > left) {
                matrix[i][j] = num;
                num++;
                j--;
            }
            while (i > top) {
                matrix[i][j] = num;
                num++;
                i--;
            }
            top++;
            down--;
            left++;
            right--;
            i++;
            j++;
            circle--;
        }
        if (n%2==0) return matrix;
        else {
            matrix[i][j] = num;
            return matrix;
        }
    }

    public static void main(String[] args) {
        generateMatrix(4);
    }
}
