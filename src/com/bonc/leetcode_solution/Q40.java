package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-04 21:09
 * @description:
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 */
public class Q40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(candidates, target, res, ans, 0, candidates.length-1);
        return res;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> ans, int begin, int end){
        if (target==0){
            if (!res.contains(ans)){
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        if (target<candidates[0]){
            return;
        }
        for (int i=begin;i<=end;i++){
            ans.add(candidates[i]);
            dfs(candidates, target-candidates[i], res, ans, i+1, end);
            ans.remove(ans.size()-1);
        }
    }
}
