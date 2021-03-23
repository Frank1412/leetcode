package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-23 21:21
 * @description:
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class Q47 {

    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(res, arr, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> arr, int[] nums){
        if(arr.size()==nums.length){
            if(!res.contains(arr)){
                res.add(new ArrayList<>(arr));
            }
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(!used[i]){
                arr.add(nums[i]);
                used[i]=true;
                dfs(res, arr, nums);
                used[i] = false;
                arr.remove(arr.size()-1);
            }
        }
    }
}
