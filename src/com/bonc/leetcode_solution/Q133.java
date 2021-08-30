package com.bonc.leetcode_solution;

import java.util.*;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-28 16:56
 * @description: Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * Test case format:
 * For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.
 * An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 * The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
 * <p>
 * Example 1:
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * <p>
 * Example 2:
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
 * <p>
 * Example 3:
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 * <p>
 * Example 4:
 * Input: adjList = [[2],[1]]
 * Output: [[2],[1]]
 */
public class Q133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node==null) return null;

        // DFS
//        HashMap<Node, Node> clone = new HashMap<>();
//        return dfs(node, clone);

        // BFS
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
//                map.put(cur, new Node(cur.val));
                for (Node nei : cur.neighbors) {
                    if (!map.containsKey(nei)) {
                        queue.offer(nei);
                        map.put(nei, new Node(nei.val));
                    }
                    map.get(cur).neighbors.add(map.get(nei));
                }
            }
        }
        return map.get(node);
    }

    private Node dfs(Node node, Map<Node, Node> clone) {
        if (clone.containsKey(node)) {
            return clone.get(node);
        }

        clone.put(node, new Node(node.val));
        Node newNode = clone.get(node);
        for (Node nei : node.neighbors) {
            clone.get(node).neighbors.add(dfs(nei, clone));
        }
        return newNode;
    }
}
