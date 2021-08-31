package com.bonc.leetcode_solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-30 15:48
 * @description:
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *     val: an integer representing Node.val
 *     random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 * Example 4:
 * Input: head = []
 * Output: []
 * Explanation: The given linked list is empty (null pointer), so return null.
 *
 */
public class Q138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

//        // 把List当成graph的做法 空间复杂度高
//        Map<Node, Node> map = new HashMap<>();
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(head);
//        map.put(head, new Node(head.val));
//        while (!queue.isEmpty()) {
//            Node cur = queue.poll();
//            if (cur.next!=null){
//                if(!map.containsKey(cur.next)){
//                    queue.offer(cur.next);
//                    map.put(cur.next, new Node(cur.next.val));
//                }
//                map.get(cur).next = map.get(cur.next);
//            }
//
//            if (cur.random!=null){
//                if (!map.containsKey(cur.random)){
//                    queue.offer(cur.random);
//                    map.put(cur.random, new Node(cur.random.val));
//                }
//                map.get(cur).random = map.get(cur.random);
//            }
//        }
//        return map.get(head);

        // List遍历
        Node p = head;
        Map<Node, Node> map = new HashMap<>();
        map.put(head, new Node(head.val));
        while (p!=null){
            if (p.next!=null){
                if (!map.containsKey(p.next)){
                    map.put(p.next, new Node(p.next.val));
                }
                map.get(p).next = map.get(p.next);
            }
            if (p.random != null) {
                if (!map.containsKey(p.random)){
                    map.put(p.random, new Node(p.random.val));
                }
                map.get(p).random = map.get(p.random);
            }

            p = p.next;
        }
        return map.get(head);
    }

}
