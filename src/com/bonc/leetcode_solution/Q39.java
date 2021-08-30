package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-04 20:34
 * @description:
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class Q39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(candidates, target, res, ans, 0, candidates.length-1);
        return res;
    }
    public void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> ans, int begin, int end){
        if (target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if (target<candidates[0]){
            return;
        }
        for (int i=begin;i<=end;i++){
            ans.add(candidates[i]);
            dfs(candidates, target-candidates[i], res, ans, i, end);
            ans.remove(ans.size()-1);
        }
    }
}
