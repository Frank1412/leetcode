package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-08 19:05
 * @description:
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class Q54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int nums = Math.min(matrix.length, matrix[0].length)/2;
        List<Integer> result = new ArrayList<>();

        int i=0,j=0, down=matrix.length, right = matrix[0].length, top=0, left=0;
        while (nums>0){
            for (;j<right-1;j++){
                result.add(matrix[i][j]);
            }

            for (;i<down-1;i++){
                result.add(matrix[i][j]);
            }

            for (;j>left;j--){
                result.add(matrix[i][j]);
            }

            for (;i>top;i--){
                result.add(matrix[i][j]);
            }
            top++;
            down--;
            left++;
            right--;
            j++;
            i++;
            nums--;
        }
        if (matrix.length>matrix[0].length&&left<right){
            for (;i<down;i++){
                result.add(matrix[i][j]);
            }
        }
        if (matrix.length<=matrix[0].length&&top<down){
            for (;j<right;j++){
                result.add(matrix[i][j]);
            }
        }

        return result;
    }
}
