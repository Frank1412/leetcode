package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-04 21:08
 * @description:
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Q78 {
    public static List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(0, nums, result, cur);
        return result;
    }

    public static void dfs(int index, int[] nums, List<List<Integer>> res, List<Integer> cur){
        if(index>nums.length-1){
            res.add(new ArrayList<>(cur));
            return;
        }

        dfs(index+1, nums, res, cur);
        cur.add(nums[index]);
        dfs(index+1, nums, res, cur);
        cur.remove(cur.size()-1);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{1,2,3});
        System.out.println(res);
        System.out.println("sf".substring(0,1));
    }
}
