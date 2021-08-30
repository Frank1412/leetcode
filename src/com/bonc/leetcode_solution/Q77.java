package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-11 10:51
 * @description:
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 */
public class Q77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(res, ans, k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> ans, int k, int index, int n){
        if (ans.size()==k){
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i=index;i<=n;i++){
            ans.add(i);
            dfs(res, ans, k, i+1, n);
            ans.remove(ans.size()-1);
        }
    }

}
