package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-01 15:24
 * @description:
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * 示例 3：
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 *
 * 示例 4：
 * 输入：head = [1], k = 1
 * 输出：[1]
 *
 */
public class Q25 {

    public static class ListNode{
        int val;
        ListNode next;

        ListNode(){};
        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k==1) return head;

        int n=k;
        ListNode tmp = head, last=head;
        while (n > 0) {
            if (tmp != null) {
                tmp = tmp.next;
            }else{
                return head;
            }
            n--;
        }
        ListNode newHead = reverse(head, tmp);
        last.next = reverseKGroup(tmp, k);

        return newHead;
    }

    public ListNode reverse(ListNode head, ListNode next){
        if (head == null||head.next==next) {
            return head;
        }
        ListNode newhead = reverse(head.next, next);
        head.next.next = head;
        head.next = next;
        return newhead;
    }
}
