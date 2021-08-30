package com.bonc.leetcode_solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-02-18 21:21
 */
public class Q111 {
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

    public int minDepth(TreeNode root) {

        //DFS
//        return helper(root);

        // BFS
        int depth = 0;
        if (root==null){
            return depth;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode cur = queue.poll();
                if (cur.left==null && cur.right==null){
                    return depth+1;
                }
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null) queue.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }

    private int helper(TreeNode root){
        if(root==null) return 0;

        if(root.left==null&&root.right==null) return 1;

        int minlen = Integer.MAX_VALUE;
        if(root.right!=null){
            minlen =  Math.min(helper(root.right)+1, minlen);
        }
        if(root.left!=null){
            minlen = Math.min(helper(root.left)+1, minlen);
        }
        return minlen;
    }
}
