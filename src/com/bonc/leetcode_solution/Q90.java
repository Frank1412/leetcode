package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-06 9:43
 * @description:
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 */
public class Q90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, 0, nums, cur);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> s: result){
            res.add(new ArrayList<>(s));
        }
        return res;
    }

    public void dfs(Set<List<Integer>> res, int index, int[] nums, List<Integer> cur){
        if(index>nums.length-1){
            if(res.contains(new ArrayList<>(cur))){
                return;
            }else{
                res.add(new ArrayList<>(cur));
                return;
            }
        }

        dfs(res, index+1, nums, cur);
        cur.add(nums[index]);
        dfs(res, index+1, nums, cur);
        cur.remove(cur.size()-1);
    }
}
