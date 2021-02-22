package com.bonc.leetcode_solution;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-02-22 21:56
 */
public class Q129 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int total_sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root==null){
            return 0;
        }
        dfs(root, 0);
        return total_sum;
    }

    public void dfs(TreeNode node, int value){
        if (node.left==null && node.right==null){
            total_sum += value*10+node.val;
            return;
        }
        if (node.left!=null){
            dfs(node.left, value*10+node.val);
        }
        if (node.right!=null){
            dfs(node.right, value*10+node.val);
        }

    }
}
