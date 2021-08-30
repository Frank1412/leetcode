package com.bonc.leetcode_solution;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-21 14:56
 * @description:
 */
public class ListNode {
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
