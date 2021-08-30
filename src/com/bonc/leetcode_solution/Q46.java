package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-23 20:38
 * @description:
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 */
public class Q46 {

    boolean[] memo;
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        memo = new boolean[n];
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(arr, nums);
        return res;
    }

    public void dfs(List<Integer> arr, int[] nums){
        if(arr.size()==nums.length){
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!memo[i]) {
                arr.add(nums[i]);
                memo[i] = true;
                dfs(arr, nums);
                memo[i] = false;
                arr.remove(arr.size()-1);
            }
        }
    }
}
