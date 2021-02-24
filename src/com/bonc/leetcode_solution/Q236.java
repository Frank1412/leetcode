package com.bonc.leetcode_solution;

/**
 * @Author: Frank
 * @Date: 2021-02-24 14:53
 * @Description: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class Q236 {

    // 时间复杂度太高！！！！
//    TreeNode res = null;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (isAncestor(root, p)&&isAncestor(root, q)){
//            res = root;
//            if (root.left!=null){
//                lowestCommonAncestor(root.left, p,q);
//            }
//            if (root.right!=null){
//                lowestCommonAncestor(root.right, p,q);
//            }
//        }
//        return res;
//    }
//
//    public Boolean isAncestor(TreeNode root, TreeNode t){
//        if (root.left==null && root.right==null){
//            return root == t;
//        }
//        if (root==t) return true;
//
//        boolean left = root.left!=null?isAncestor(root.left, t):false;
//        boolean right = root.right!=null?isAncestor(root.right, t):false;
//
//        return left||right;
//    }

    // 后序遍历！！！
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left!=null && right!=null){
            return root;
        }
        if (left==null && right==null){
            return null;
        }
        if (left == null){
            return right;
        }
        return left;
    }
}
