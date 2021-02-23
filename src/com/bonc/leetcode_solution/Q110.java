package com.bonc.leetcode_solution;

/**
 * @Author: Frank
 * @Date: 2021-02-23 16:21
 * @Description:
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 */
public class Q110 {

    boolean isbalance = true;
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
            return true;
        }
        pathSum(root);
        return isbalance;
    }

    public int pathSum(TreeNode node){
        if (node.left==null && node.right==null){
            return 1;
        }

        int left = node.left!=null?pathSum(node.left):0;
        int right = node.right!=null?pathSum(node.right):0;
        if (Math.abs(left-right)>1){
            isbalance = false;
        }

        return Math.max(left, right)+1;
    }
}
