package com.bonc.leetcode_solution;

import java.util.HashSet;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-04 21:22
 * @description:
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 *
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 */
public class Q41 {
    public static int firstMissingPositive(int[] nums) {

        // 哈希表存储 不满足要求
//        int min = 1;
//        HashSet<Integer> hs = new HashSet<>();
//        for (int num: nums){
//            System.out.println(num);
//            if (num>0&&!hs.contains(num)){
//                hs.add(num);
//            }
//        }
//        System.out.println(hs);
//        while (true){
//            if (hs.contains(min)){
//                min++;
//            }else{
//                break;
//            }
//        }
//        return min;

        // 把数组转为hash表
        for (int i=0;i<nums.length;i++){
            while (nums[i]-1<nums.length&&nums[i]-1>=0&&nums[nums[i]-1]!=nums[i]){
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }


    public static void main(String[] args) {
        firstMissingPositive(new int[]{3,4,-1,1});
    }
}
