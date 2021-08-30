package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-30 0:21
 * @description:
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 *
 */
public class Q136 {
    public int singleNumber(int[] nums) {

        // HashSet O(n), 不符合常数空间复杂度
//        Set<Integer> hs = new HashSet<>();
//        for (int n: nums){
//            if (hs.contains(n)){
//                hs.remove(n);
//            }else{
//                hs.add(n);
//            }
//        }
//        return new ArrayList<>(hs).get(0);

        // 异或运算：不带进位的二进制加法 1^0=1  0^0=0  1^1=0 0^1=1
        int res=0;
        for (int n: nums){
            res ^= n;
        }
        return res;
    }
}
