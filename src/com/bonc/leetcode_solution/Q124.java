package com.bonc.leetcode_solution;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-02-22 20:59
 */
public class Q124 {

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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        left = left > 0 ? left : 0;
        right = right > 0 ? right : 0;
        int pathSum = Math.max(left, right) + root.val;
        max = Math.max(root.val + left + right, max);
        return pathSum;
    }
}
