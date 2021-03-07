package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-07 11:10
 * @description:
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class Q53 {
    public int maxSubArray(int[] nums) {
        int[] maxSubSum = new int[nums.length];
        maxSubSum[0] = nums[0];
        int max = maxSubSum[0];
        for(int i=1;i<nums.length;i++){
            maxSubSum[i] = Math.max(maxSubSum[i-1]+nums[i], nums[i]);
            max = Math.max(max, maxSubSum[i]);
        }
        return max;
    }
}
