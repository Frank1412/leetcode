package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-06-30 13:59
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Q21 {

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode p1 = l1, p2 = l2, head = new ListNode(-100), tmp = head;
        while (p1!=null&&p2!=null){
            if (p1.val < p2.val) {
                head.next = p1;
                p1 = p1.next;
            }else{
                head.next=p2;
                p2 = p2.next;
            }
            head = head.next;
        }
        head.next = p1==null?p2:p1;
        return tmp.next;
    }
}
