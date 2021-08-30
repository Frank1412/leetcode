package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-14 20:21
 * @description:
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 */
public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length*matrix[0].length-1, m=matrix.length, n=matrix[0].length;
        while (left<=right){
            int mid = left+(right-left)/2;
            int i=mid/n, j=mid%n;
            if (matrix[i][j]==target){
                return true;
            }else if (matrix[i][j]>target){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        int i=(left+1)/n-1, j=left-i*n-1;
        return matrix[i][j] == target;
    }
}
