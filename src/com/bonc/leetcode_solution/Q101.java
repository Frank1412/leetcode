package com.bonc.leetcode_solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-02-18 20:31
 */
public class Q101 {

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

    public boolean isSymmetric(TreeNode root) {

        // 深度优先 递归
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);

        // 广度优先
//        if (root == null) {
//            return true;
//        }
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode l = queue.poll();
//            TreeNode r = queue.poll();
//            if (l == null && r == null) continue;
//
//            if (l == null || r == null) {
//                return false;
//            }
//            if (l.val != r.val) {
//                return false;
//            }
//
//            queue.offer(l.left);
//            queue.offer(r.right);
//            queue.offer(l.right);
//            queue.offer(r.left);
//        }
//        return true;
    }

    private boolean dfs(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val==right.val&&dfs(left.left, right.right)&&dfs(left.right, right.left);
    }
}
