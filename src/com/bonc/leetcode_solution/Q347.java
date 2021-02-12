package com.bonc.leetcode_solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 * @author Shouzhi Fang(frank)
 * @create 2021-02-03 20:30
 */
public class Q347 {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> num_cnt = new HashMap<>();
        for (int num: nums){
            num_cnt.put(num, num_cnt.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a1, a2)->(num_cnt.get(a1)-num_cnt.get(a2)));
        for (int e: num_cnt.keySet()){
            if (maxHeap.size()<k || num_cnt.get(maxHeap.peek()) < num_cnt.get(e)){
                maxHeap.offer(e);
            }
            if (maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int []res = new int[k];
        int i=0;
        while (!maxHeap.isEmpty()){
            res[i++] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int []arr = {1,1,1,2,2,3};
        int []result = topKFrequent(arr, 1);
        for (int r: result){
            System.out.println(r);
        }
    }
}
