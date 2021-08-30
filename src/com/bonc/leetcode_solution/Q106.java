package com.bonc.leetcode_solution;

import java.util.HashMap;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-21 10:05
 * @description: Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 */
public class Q106 {

    HashMap<Integer, Integer> hs = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            hs.put(inorder[i], i);
        }
        TreeNode root = helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return root;
    }

    private TreeNode helper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end) {
        if (i_start>i_end) return null;
        if (i_start == i_end) {
            return new TreeNode(inorder[p_start]);
        }

        TreeNode root = new TreeNode(postorder[p_end]);
        int index = hs.get(root.val);

        root.left = helper(inorder, i_start, index-1,postorder, p_start, p_start+(index-i_start)-1);
        root.right = helper(inorder, index+1, i_end,postorder, p_start+(index-i_start), p_end-1);
        return root;
    }
}
