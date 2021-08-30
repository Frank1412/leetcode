package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-07-13 14:49
 * @description: 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 */
public class Q61 {
    public class ListNode {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return head;
        int i=0;
        ListNode p = head, q=head;
        while (i<k){
            if (p.next==null){
                p = head;
            }else{
                p = p.next;
            }
            i++;
        }
        while (p.next!=null){
            p = p.next;
            q = q.next;
        }
        if (p==q) return head;

        ListNode newHead = q.next;
        p.next = head;
        q.next = null;
        return newHead;
    }
}
