package com.bonc.leetcode_solution;

import java.util.Arrays;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-20 23:00
 * @description: Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class Q105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        TreeNode root = buildT(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }

    private TreeNode buildT(int[] preorder, int p1, int p2, int[] inorder, int i1, int i2) {
        if (p2 - p1 < 0) return null;
        if (p2 - p1 == 0) {
            return new TreeNode(preorder[p1]);
        }

        int rootval = preorder[p1];
        TreeNode root = new TreeNode(rootval);
        int index = i1;
        // 找中序遍历的节点可以先用hashMap存储
        for (; index <= i2; index++) {
            if (inorder[index] == rootval) {
                break;
            }
        }

        root.left = buildT(preorder, p1 + 1, index - i1 + p1, inorder, i1, index - 1);
        root.right = buildT(preorder, index - i1 + p1 + 1, p2, inorder, index + 1, i2);
        return root;
    }
}
