package com.bonc.leetcode_solution;

/**
 * @Author: Frank
 * @Date: 2021-02-24 17:15
 * @Description:
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Follow up: Can you solve it with time complexity O(height of tree)?
 *
 */
public class Q450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null || root.val==key){
            return null;
        }
        TreeNode res = root, cur =root, pre = cur;
        while(cur!=null){
            if (cur.val == key){
                break;
            }
            pre = cur;
            cur = cur.val > key? cur.left: cur.right;
        }
        if (cur==null) return root;
        System.out.println(cur.val);

        TreeNode maxLeft = findMaxLeft(cur);
        if (pre.val > cur.val){
            pre.left = maxLeft;
        }else{
            pre.right = maxLeft;
        }
        return res;
    }

    // 找左子树的最大值
    public TreeNode findMaxLeft(TreeNode root){
        if (root.left==null){
            return root.right;
        }
        TreeNode cur = root.left, pre=root;
        while(cur.right!=null){
            pre = cur;
            cur = cur.right;
        }
        pre.right = null;
        cur.left = root.left;
        return cur;
    }
}
