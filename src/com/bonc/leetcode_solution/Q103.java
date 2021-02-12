package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-02-12 21:19
 */
public class Q103 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean odd = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> level = new LinkedList<>();

            if (odd) {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    level.offerLast(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                odd = false;
            }else{
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    level.offerFirst(cur.val);
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                }
                odd = true;
            }
            res.add(new LinkedList<>(level));
        }
        return res;
    }
}
