package com.bonc.leetcode_solution;

/**
 * @Author: Frank
 * @Date: 2021-02-23 09:14
 * @Description:
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Q98 {

    TreeNode pre;

    public boolean isValidBST(TreeNode root) {

        // 中序遍历 pre节点的值一定小于当前节点
//        if (root == null) {
//            return true;
//        }
//
//        if (!isValidBST(root.left)) {
//            return false;
//        }
//        if (pre == null) pre = root;
//        else if (pre.val >= root.val) {
//            return false;
//        }
//        pre = root;
//        return isValidBST(root.right);

        // 中序遍历常规做法
//        Stack<TreeNode> NodeList = new Stack<>();
//        long min = Long.MIN_VALUE;
//        while (root != null||!NodeList.isEmpty()) {
//            while (root!=null){
//                NodeList.push(root);
//                root = root.left;
//            }
//            root = NodeList.pop();
//            if (root.val <= min) {
//                return false;
//            }
//            min = root.val;
//            root = root.right;
//        }
//        return true;

        // 递归回溯法
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long min, long max){
        if (root==null) return true;

        TreeNode left = root.left, right = root.right;
        if (root.val <= min || root.val >= max) {
            return false;
        }

        return dfs(left, min, root.val)&&dfs(right, root.val, max);
    }
}
