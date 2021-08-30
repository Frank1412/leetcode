package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-06-29 19:53
 * @description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class Q19 {

    public static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q=head, pre=null;
        int interval = n;
        while (interval>0){
            p = p.next;
            interval--;
        }
        while (p != null) {
            p = p.next;
            pre = q;
            q = q.next;
        }
        if (q==head){
            pre = q.next;
            return pre;
        }
        pre.next = q.next;
        return head;
    }
}
