package com.bonc.leetcode_solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-01-30 1:20
 */
public class Q1 {
    public static int[] twoSum(int[] nums, int target) {

        // 蛮力法
//		int a[] = new int[2];
//		for (int i =0; i<nums.length;i++) {
//			for(int j = i+1; j<nums.length;j++) {
//				if (nums[i]+nums[j] == target) {
//					a[0] = i;
//					a[1] = j;
//					break;
//				}
//			}
//		}
//		return a;

        // 哈希表
        Map<Integer, Integer> numMap = new HashMap<>();
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!numMap.containsKey(target - nums[i])) {
                numMap.put(nums[i], i);
            } else {
                int j = numMap.get(target - nums[i]);
                a[0] = i;
                a[1] = j;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a1 = new int[] {1,2,3};
        int tgr = 4;
        int[] result = twoSum(a1, tgr);
        System.out.println(result.length);
    }
}
