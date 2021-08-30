package com.bonc.leetcode_solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-27 12:51
 * @description:
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
public class Q128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int c: nums){
            set.add(c);
        }

        int res = 0;
        for (int num: set){
            if (!set.contains(num-1)){
                int len = 1, tmp = num+1;
                while(set.contains(tmp)){
                    tmp++;
                    len++;
                }
                res = Math.max(len, res);
            }
        }
        return res;
    }
}
