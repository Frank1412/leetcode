package com.bonc.leetcode_solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-05 20:21
 * @description:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: [2,3,0,1,4]
 * 输出: 2
 *
 */
public class Q45 {
    public int jump(int[] nums) {

        int step = 0, maxPos=0;
        int i=0, end=0;
        while (i<nums.length) {
            maxPos = Math.max(nums[i] + i, maxPos);
            if (i==end){
                end = maxPos;
                step++;
            }
            i++;
        }
        return step;

    }

    public static void main(String[] args) {
        Q45 q45 = new Q45();
        q45.jump(new int[]{2,0,2,0,1});
    }
}
