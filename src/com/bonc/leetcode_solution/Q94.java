package com.bonc.leetcode_solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-16 22:34
 * @description:
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 */
public class Q94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        // 递归法
//        List<Integer> res = new ArrayList<>();
//        dfs(res, root);
//        return res;

        // 迭代法
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    private void dfs(List<Integer> res, TreeNode root){
        if (root==null){
            return;
        }
        dfs(res,root.left);
        res.add(root.val);
        dfs(res, root.right);
    }
}
