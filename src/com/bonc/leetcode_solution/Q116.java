package com.bonc.leetcode_solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-22 10:09
 * @description:
 */
public class Q116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

        // 使用已建立的 next 指针
        if (root==null) return null;

        Node head = root;
        while (head.left != null) {
            head.left.next = head.right;
            Node cur = head;
            while (cur.next != null) {
                cur.right.next = cur.next.left;
                cur = cur.next;
                cur.left.next = cur.right;
            }
            head = head.left;
        }
        return root;

        // BFS
//        if (root==null) return null;
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            for (int i=0;i<size;i++){
//                Node cur = queue.poll();
//                if (cur.left != null) {
//                    queue.offer(cur.left);
//                }
//                if (cur.right != null) {
//                    queue.offer(cur.right);
//                }
//                if (i == size - 1) {
//                    cur.next = null;
//                }else{
//                    cur.next = queue.peek();
//                }
//            }
//        }
//        return root;
    }
}
