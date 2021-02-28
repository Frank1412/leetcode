package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-02-27 22:35
 * @description: A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:
 * <p>
 * The first word in the sequence is beginWord.
 * The last word in the sequence is endWord.
 * Only one letter is different between each adjacent pair of words in the sequence.
 * Every word in the sequence is in wordList.
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class Q127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new LinkedList<>();

        visited.add(beginWord);
        queue.offer(beginWord);

        // 构建图
//        Map<String, List<String>> graph = constructGraph(wordList);
//        int step = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String cur = queue.poll();
//                if (cur.equals(endWord)) return step;
//                for (String neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
//                    if (!visited.contains(neighbor)) {
//                        queue.offer(neighbor);
//                        visited.add(neighbor);
//                    }
//                }
//            }
//            step++;
//        }
//        return 0;

        // 没构建图
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return step;
                for (int j=0;j<wordList.size();j++) {
                    String neighbor = wordList.get(j);
                    if (!visited.contains(neighbor)&&oneStep(cur, neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private Map<String, List<String>> constructGraph(List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        int n = wordList.size();
        for (int i = 0; i < n - 1; i++) {
            String s1 = wordList.get(i);
            for (int j = i + 1; j < n; j++) {
                String s2 = wordList.get(j);
                if (oneStep(s1, s2)) {
                    graph.computeIfAbsent(s1, k -> new ArrayList<>()).add(s2);
                    graph.computeIfAbsent(s2, k -> new ArrayList<>()).add(s1);
                }
            }
        }
        return graph;
    }

    public Boolean oneStep(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count == 1;
    }
}
