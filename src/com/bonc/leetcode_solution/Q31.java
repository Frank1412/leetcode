package com.bonc.leetcode_solution;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-01 20:37
 * @description:
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *
 */
public class Q31 {
    public void nextPermutation(int[] nums) {

        int i=nums.length-1;
        while (i>0){
            if (nums[i-1]<nums[i]){
                break;
            }
            i--;
        }
        if (i == 0) {
            int left=0, right=nums.length-1;
            while(left<right){
                swap(nums, left, right);
                left++;
                right--;
            }
            return;
        }
        int j;
        for (j=nums.length-1;j>i-1;j--){
            if (nums[j]>nums[i-1]){
                break;
            }
        }
        swap(nums, i-1, j);
        int p=i, q=nums.length-1;
        while(p<q){
            swap(nums, p, q);
            p++;
            q--;
        }
    }


    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
