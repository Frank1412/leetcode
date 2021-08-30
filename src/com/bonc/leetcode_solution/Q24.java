package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-06-30 22:20
 * @description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 */
public class Q24 {
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

    public ListNode swapPairs(ListNode head) {

        // 迭代法
//        ListNode pre = new ListNode(0), cur=pre;
//        pre.next = head;
//        while (pre.next != null&&pre.next.next!=null) {
//            ListNode p1=pre.next, p2=pre.next.next;
//            p1.next = p2.next;
//            p2.next=p1;
//            pre.next = p2;
//            pre = p1;
//        }
//        return cur.next;

        // 递归法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = swapPairs(head.next.next);
        ListNode tmp = head.next;
        head.next.next = head;
        head.next = next;
        return tmp;
    }

}
