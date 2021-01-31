package com.bonc.leetcode_solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-01-31 23:08
 */
public class Q23 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(), finalList = new ListNode(0), res = finalList;
//        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val-o2.val;
//            }
//        });
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode l1, ListNode l2)->(l1.val-l2.val));
        for (int i=0; i<lists.length;i++){
            if (lists[i]!=null){
                minHeap.offer(lists[i]);
            }

        }
        while (!minHeap.isEmpty()){
            ListNode cur = minHeap.poll();
            finalList.next = cur;
            finalList = finalList.next;
            if (cur.next!=null){
                minHeap.offer(cur.next);
            }
        }
        return res.next;
    }
}
