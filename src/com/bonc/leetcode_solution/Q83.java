package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-14 17:08
 * @description:
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 *
 */
public class Q83 {

    class ListNode{
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

    public ListNode deleteDuplicates(ListNode head) {

//        ListNode dummyHead = new ListNode(0, head), cur = head, pre = dummyHead;
//        pre.next = head;
//        while (cur!=null&&cur.next!=null){
//            if (cur.val==cur.next.val){
//                while (cur.next!=null&&cur.val == cur.next.val){
//                    cur = cur.next;
//                }
//            }
//            pre.next = cur;
//            pre = cur;
//            cur = cur.next;
//        }
//        return dummyHead.next;

        // better way
        if (head==null) return head;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
