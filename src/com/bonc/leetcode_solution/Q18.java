package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-06-29 19:20
 * @description:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [], target = 0
 * 输出：[]
 *
 */
public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int p=j+1,q=len-1;
                while (p<q){
                    int sum = nums[p] + nums[q] + nums[i] + nums[j];
                    if (sum == target) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[p]);
                        ans.add(nums[q]);
                        if (!res.contains(ans)){
                            res.add(ans);
                        }
                        p++;
                        while (p<q&&nums[p]==nums[p-1]){
                            p++;
                        }
                        q--;
                        while (q>p&&nums[q]==nums[q+1]){
                            q--;
                        }
                    }else if (sum > target){
                        q--;
                    }else{
                        p++;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
