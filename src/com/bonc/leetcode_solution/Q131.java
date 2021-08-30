package com.bonc.leetcode_solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Shouzhi Fang(frank)
 * @create: 2021-08-28 12:26
 * @description: Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * A palindrome string is a string that reads the same backward as forward.
 * <p>
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * <p>
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 */
public class Q131 {

    List<List<String>> res = new LinkedList<>();
    Boolean[][] isPalindrome;

    public List<List<String>> partition(String s) {

        // 回溯法
        isPalindrome = new Boolean[s.length()][s.length()];
        List<String> cur = new LinkedList<>();
        dfs(s, 0, cur);
        return res;
    }

    private void dfs(String s, int index, List<String> cur) {
        if (index == s.length()) {
            res.add(new LinkedList<>(cur));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String tmp = s.substring(index, i + 1);
            if (isPalindrome(s, index, i)) {
                cur.add(tmp);
                dfs(s, i + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (isPalindrome[i][j]!=null) return isPalindrome[i][j];
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                isPalindrome[i][j]=false;
                return false;
            }
            i++;
            j--;
        }
        isPalindrome[i][j] = true;
        return true;
    }
}
