package com.bonc.leetcode_solution;

/**
 * @Author: Frank
 * @Date: 2021-02-23 09:15
 * @Description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (){}
    TreeNode (int val){this.val = val;}
    TreeNode (int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
