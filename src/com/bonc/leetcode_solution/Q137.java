package com.bonc.leetcode_solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-30 12:53
 * @description:
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 *
 */
public class Q137 {
    public int singleNumber(int[] nums) {

        // 哈希表
//        HashMap<Integer, Integer> memo = new HashMap<>();
//        for (int n: nums){
//            memo.put(n, memo.getOrDefault(n, 0)+1);
//        }
//
//        int res = 0;
//        for (Map.Entry<Integer, Integer> entry: memo.entrySet()){
//            if (entry.getValue()==1){
//                res = entry.getKey();
//            }
//        }
//        return res;

        // 位数统计 使用一个长度为 323232 的数组 cnt[]cnt[]cnt[] 记录下所有数值的每一位共出现了多少次 111，再对 cnt[]cnt[]cnt[] 数组的每一位进行 modmodmod 333 操作，
        // 重新拼凑出只出现一次的数值。举个 🌰，考虑样例 [1,1,1,3]，111 和 333 对应的二进制表示分别是 00..001 和 00..011，存入 cnt[]cnt[]cnt[] 数组后得到 [0,0,...,0,1,4]。
        // 进行 modmodmod 333 操作后得到 [0,0,...,0,1,1]，再转为十进制数字即可得「只出现一次」的答案 333。

        int[] cnt = new int[32];
        for(int n: nums){
            for (int i=0;i<32;i++){
                if (((n>>i)&1) == 1){
                    cnt[i] += 1;
                }
            }
        }

        int res = 0;
        for (int i=0;i<32;i++){
            if (((cnt[i]>>i)%3 & 1) ==1){
                res += (1<<i);
            }
        }
        return res;
    }
}
