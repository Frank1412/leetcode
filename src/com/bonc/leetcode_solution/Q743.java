package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-02-28 17:31
 * @description:
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 */
public class Q743 {
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, ArrayList<int []>> graph = new HashMap<>();
        for (int[] time: times){
            graph.computeIfAbsent(time[0], t->new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((int[] a, int[] b)->a[1]-b[1]);
        minHeap.offer(new int[]{k, 0});
        Map<Integer, Integer> costs = new HashMap<>();
        costs.put(k, 0);
        while (!minHeap.isEmpty()){
            int size = minHeap.size();
            for (int i=0;i<size;i++){
                int[] cur = minHeap.poll();
                if (!costs.containsKey(cur[0])){
                    costs.put(cur[0], cur[1]);
                }else{
                    costs.put(cur[0], Math.min(costs.get(cur[0]), cur[1]));
                }
                if (graph.containsKey(cur[0])){
                    for (int[] nei: graph.get(cur[0])){
                        if (!costs.containsKey(nei[0])){
                            minHeap.offer(new int[]{nei[0], nei[1]+cur[1]});
                        }
                    }
                }
            }
        }
        if (costs.size()!=n) return -1;
        int max = 0;
        for (int cost: costs.values()){
            max = Math.max(max, cost);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] t1 = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int[][] t2 = new int[][]{{1,2,1}};
        int[][] t3 = new int[][]{{1,2,1},{2,3,2},{1,3,4}};
        int res = networkDelayTime(t3, 3, 1);
        System.out.println("ans="+res);
    }
}
