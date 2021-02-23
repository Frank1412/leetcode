package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @Author: Frank
 * @Date: 2021-02-23 17:44
 * @Description:
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 *
 * A leaf is a node with no children.
 *
 */
public class Q113 {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null) return res;
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int targetSum){
        if (root.left==null && root.right==null){
            if (targetSum-root.val==0){
                path.offerLast(root.val);
                res.add(new LinkedList<>(path));
                path.pollLast();
            }
            return;
        }
        int sum = targetSum - root.val;
        path.addLast(root.val);
        if (root.left!=null){
            dfs(root.left, sum);
        }
        if (root.right!=null){
            dfs(root.right, sum);
        }
        path.pollLast();
    }
}
