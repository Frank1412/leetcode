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
        int depth = 0;
        if (root==null){
            return depth;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
//        depth++;
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
}
