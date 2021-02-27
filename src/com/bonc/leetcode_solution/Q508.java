package com.bonc.leetcode_solution;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-02-24 21:48
 * @description:
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 */
public class Q508 {
    int max = 0;
    Map<Integer, Integer> set = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root==null){
            return new int[]{};
        }
        subTreeSum(root);

        System.out.println(set);
        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: set.entrySet()){
            if (entry.getValue()==max) res.add(entry.getKey());
        }
        int[] ans = new int[res.size()];
        int i=0;
        while (i<res.size()){
            ans[i] = res.get(i);
            i++;
        }
        return ans;
    }

    public int subTreeSum(TreeNode root){
        if (root.left==null && root.right==null){
            set.put(root.val, set.getOrDefault(root.val, 0)+1);
            max = Math.max(max, set.get(root.val));
            return root.val;
        }

        int left = root.left!=null?subTreeSum(root.left):0;
        int right = root.right!=null?subTreeSum(root.right):0;
        int sum = left + right + root.val;
        set.put(sum, set.getOrDefault(sum, 0)+1);
        max = Math.max(max, set.get(sum));
        return sum;
    }
}
