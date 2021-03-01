package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-01 21:26
 * @description:
 */
public class Q787 {

    static class Cell implements Comparable<Cell>{
        int dst, stop, cost;

        public Cell(int dst, int stop, int cost) {
            this.dst = dst;
            this.stop = stop;
            this.cost = cost;
        }

        public int compareTo(Cell other){
            return this.cost-other.cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = constructGraph(flights);


//        Map<Integer, Integer> costs = new HashMap<>();
//        Deque<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{src, 0});
//        int count=0;
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            for (int i=0;i<size;i++){
//                int[] cur = queue.pollFirst();
//                if (costs.containsKey(cur[0])){
//                    costs.put(cur[0], Math.min(costs.get(cur[0]), cur[1]));
//                }else{
//                    costs.put(cur[0], cur[1]);
//                }
//                if (!graph.containsKey(cur[0])){
//                    continue;
//                }
//                for(int[] nei: graph.get(cur[0])){
//                    queue.offerLast(new int[]{nei[0], cur[1]+nei[1]});
//                }
//            }
//            if (count>K) break;
//            count++;
//        }
//        if (!costs.containsKey(dst)) return -1;
//        else return costs.get(dst);

        // 使用小顶堆
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();
        minHeap.offer(new Cell(src, K, 0));
        while(!minHeap.isEmpty()){
            int size = minHeap.size();
            for(int i=0;i<size;i++){
                Cell cur = minHeap.poll();
                if(cur.dst == dst) {
                    return cur.cost;
                }
                if (cur.stop>0&&graph.containsKey(cur.dst)){
                    for(int[] nei: graph.get(cur.dst)){
                        minHeap.offer(new Cell(nei[0], cur.stop-1, cur.cost+nei[1]));
                    }
                }
            }
        }

        return -1;
    }

    public Map<Integer, List<int[]>> constructGraph(int[][] flights){
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight: flights){
//            List<int[]> nei = graph.getOrDefault(flight[0], new ArrayList<>());
//            nei.add(new int[]{flight[1], flight[2]});
//            graph.put(flight[0], nei);
            graph.computeIfAbsent(flight[0], k->new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }
        return graph;
    }

}
