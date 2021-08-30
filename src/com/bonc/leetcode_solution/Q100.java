package com.bonc.leetcode_solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-19 22:37
 * @description:
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 */
public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // 深度优先
//        if (p == null && q == null) {
//            return true;
//        } else if (q == null || p == null) {
//            return false;
//        } else if (q.val != p.val) {
//            return false;
//        }else{
//            return isSameTree(q.left, p.left)&&isSameTree(q.right, p.right);
//        }

        // 宽度优先
        Queue<TreeNode> q1 = new LinkedList<>(), q2=new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            if (node1 == null && node2 == null) {
                continue;
            }

            if ((node1==null||node2==null) || node1.val!=node2.val){
                return false;
            }
            TreeNode left1=node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;

            q1.offer(left1);
            q1.offer(right1);
            q2.offer(left2);
            q2.offer(right2);
        }
        return q1.isEmpty()&&q2.isEmpty();
    }
}
