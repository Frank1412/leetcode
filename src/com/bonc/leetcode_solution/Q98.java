package com.bonc.leetcode_solution;

/**
 * @Author: Frank
 * @Date: 2021-02-23 09:14
 * @Description:
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Q98 {

    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }

        if (!isValidBST(root.left)){
            return false;
        }
        if (pre==null) pre = root;
        else if (pre.val >= root.val){
            return false;
        }
        pre = root;
        return isValidBST(root.right);
    }
}
