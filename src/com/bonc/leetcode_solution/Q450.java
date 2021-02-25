package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-02-24 18:54
 * @description:
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

        // 递归解法
//        if (root==null) return null;
//        if (root.val > key){
//            root.left = deleteNode(root.left, key);
//        }else if (root.val < key){
//            root.right = deleteNode(root.right, key);
//        }else{
//            if (root.left==null&&root.right==null){
//                return null;
//            }
//            if (root.left==null){
//                return root.right;
//            }
//            if (root.right==null){
//                return root.left;
//            }
//            TreeNode leftMax = findLeftMax(root.left);
//            root.val = leftMax.val;
//            root.left = deleteNode(root.left, root.val);
//        }
//        return root;

        // 迭代法
        if (root==null){
            return null;
        }
        TreeNode cur =root, pre = null;
        while(cur!=null){
            if (cur.val == key){
                break;
            }
            pre = cur;
            cur = cur.val > key? cur.left: cur.right;
        }
        if (pre==null){
            return findLeftMax_reconstruct(root);
        }
        if (cur==null) return root;

        TreeNode maxLeft = findLeftMax_reconstruct(cur);
        if (pre.val > cur.val){
            pre.left = maxLeft;
        }else{
            pre.right = maxLeft;
        }
        return root;
    }

    /**
     * 递归法 找左子树最大
     * @param root
     * @return
     */
    public TreeNode findLeftMax(TreeNode root){
        while (root.right!=null){
            root = root.right;
        }
        return root;
    }

    /**
     * 迭代法 找左子树最大值，并重构，把root.right赋给左子树最right的right
     * @param root
     * @return
     */
    public TreeNode findLeftMax_reconstruct(TreeNode root){
        if (root.left==null){
            return root.right;
        }
        TreeNode cur = root.left;
        while(cur.right!=null){
            cur = cur.right;
        }
        cur.right = root.right;
        return root.left;
    }
}
