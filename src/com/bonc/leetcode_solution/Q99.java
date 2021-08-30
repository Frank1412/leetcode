package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-19 20:03
 * @description:
 * You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 * Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 * Example 1:
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 *
 * Example 2:
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 *
 */

import java.util.Deque;
import java.util.LinkedList;

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
public class Q99 {

    private TreeNode pre = new TreeNode(Integer.MIN_VALUE), firstMax=null, lastMin = null;

    public void recoverTree(TreeNode root) {

        dfs(root);
        swap(firstMax, lastMin);
    }

    private void dfs(TreeNode root){
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (root.val < pre.val) {
            lastMin = root;
            if (firstMax==null) firstMax = pre;
        }

        pre = root;
        dfs(root.right);
    }

    private void swap(TreeNode firstMax, TreeNode lastMin){
        int tmp = firstMax.val;
        firstMax.val = lastMin.val;
        lastMin.val = tmp;
    }
}
