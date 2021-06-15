package com.bonc.leetcode_solution;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Q283 {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while (j<nums.length){
            if (nums[j]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {

    }
}
