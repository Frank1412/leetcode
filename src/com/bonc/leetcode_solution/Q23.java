package com.bonc.leetcode_solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-01-31 23:08
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
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
