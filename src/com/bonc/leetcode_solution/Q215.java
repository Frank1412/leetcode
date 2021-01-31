package com.bonc.leetcode_solution;

import com.sun.glass.ui.Size;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Shouzhi Fang(frank)
 * @create 2021-01-31 22:27
 */
public class Q215 {

    public int findKthLargest(int[] nums, int k) {

        // 默认小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((Integer o1, Integer o2)->(o1.compareTo(o2)));
//        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
        for (int e: nums){
            if (queue.size()<k && queue.peek() <= e){
                queue.offer(e);
            }
            if (queue.size()>k){
                queue.poll();
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {

    }
}
