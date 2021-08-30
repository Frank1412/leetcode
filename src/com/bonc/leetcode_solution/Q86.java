package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-15 10:39
 * @description:
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example 1:
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 *
 * Example 2:
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 */
public class Q86 {
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

    public ListNode partition(ListNode head, int x) {

        ListNode lessNode = new ListNode(0), lessHead = lessNode, noLessNode = new ListNode(0), noLessHead = noLessNode;
        ListNode pre = new ListNode(0);
        pre.next = head;
        while (head!=null){
            if (head.val<x){
                lessNode.next = head;
                lessNode = lessNode.next;
            }else{
                noLessNode.next = head;
                noLessNode = noLessNode.next;
            }
//            pre = head;
//            pre.next = null;
            head = head.next;
        }
        noLessNode.next = null;
        lessNode.next = noLessHead.next;
        return lessHead.next;
    }
}
