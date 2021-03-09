package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-09 21:24
 * @description:
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Implement the NumArray class:
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))
 */
public class Q303 {
    int[] sum;

    public Q303(int[] nums) {
        sum = new int[nums.length+1];
        sum[1] = nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i+1] = sum[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}
