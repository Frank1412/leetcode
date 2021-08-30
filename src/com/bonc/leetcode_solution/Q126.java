package com.bonc.leetcode_solution;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-25 17:56
 * @description: A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * <p>
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].
 * <p>
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 * <p>
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class Q126 {


    private Map<String, Set<String>> graph = new HashMap<>();

    // 构建图，相当于寻找最短路径问题,BFS
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        createGraph(beginWord, wordList, graph);
        Map<String, List<String>> parents = new HashMap<>();
        parents.put(beginWord, null);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<String, List<String>> tmp_parents = new HashMap<>();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String nei : graph.get(cur)) {
                    if (!parents.containsKey(nei)){
                        if (!tmp_parents.containsKey(nei)) {
                            queue.offer(nei);
                        }
                        tmp_parents.computeIfAbsent(nei, k -> new ArrayList<>()).add(cur);
                    }
                }
            }
            // 后添加的 index靠前
            parents.putAll(tmp_parents);

            if (tmp_parents.containsKey(endWord)) {
                List<List<String>> res = new ArrayList<>();
                List<String> cur = new LinkedList<>();
                cur.add(endWord);
                dfs(res, beginWord, endWord, cur, parents);
                return res;
            }
        }


        return new ArrayList<>();
    }

    private void createGraph(String beginWord, List<String> wordList, Map<String, Set<String>> graph) {
        for (String s1 : wordList) {
            Set<String> set = new HashSet<>();
            for (String s2 : wordList) {
                if (helper(s1, s2)) {
                    set.add(s2);
                }
            }
            graph.put(s1, set);
        }
        Set<String> nei = new HashSet<>();
        for (String s : wordList) {
            if (helper(beginWord, s)) {
                nei.add(s);
            }
        }
        graph.put(beginWord, nei);
    }

    private void dfs(List<List<String>> res, String beginWord, String endWord, List<String> cur, Map<String, List<String>> parents) {
        if (endWord.equals(beginWord)) {
            res.add(new LinkedList<>(cur));
            return;
        }
        for (String nei :parents.get(endWord)) {
            cur.add(0, nei);
            dfs(res, beginWord, nei, cur, parents);
            cur.remove(0);
        }
    }

    private boolean helper(String s1, String s2) {
        int n = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                n++;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

        new Q126().findLadders(beginWord, endWord, wordList);
    }
}
