package com.bonc.leetcode_solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-02-22 19:53
 */
public class Q104 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (){}
        TreeNode (int val){this.val = val;}
        TreeNode (int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int maxDepth(TreeNode root) {

        // DFS
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;

        // BFS
//        if (root==null){
//            return 0;
//        }
//        Deque<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        int depth = 0;
//
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            for (int i=0;i<size;i++){
//                TreeNode cur = queue.peek();
//                if (cur.left!=null){
//                    queue.offer(cur.left);
//                }
//                if (cur.right!=null){
//                    queue.offer(cur.right);
//                }
//                queue.poll();
//            }
//            depth++;
//        }
//        return depth;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pri = new PriorityQueue<>();
        pri.offer(1);
        pri.offer(3);
        pri.offer(3);
        pri.offer(2);
        System.out.println(pri);
    }
}
