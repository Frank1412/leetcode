package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-03-03 21:16
 * @description:
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 *
 */
public class Q332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>()).offer(pair.get(1));
        }
        String src = "JFK";
        List<String> result = new LinkedList<>();
        dfs(src, graph, result);
        return result;
    }

    public void dfs(String city, Map<String, PriorityQueue<String>> graph, List<String> res){
        PriorityQueue<String> neighbors = graph.getOrDefault(city, new PriorityQueue<>());
        while(!neighbors.isEmpty()){
            dfs(neighbors.poll(), graph, res);
        }

        res.add(0, city);
    }
}
